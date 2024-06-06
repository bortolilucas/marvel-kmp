package core.presentation.util.gif

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.suspendCancellableCoroutine
import platform.CoreFoundation.CFDataRef
import platform.CoreGraphics.CGImageRef
import platform.Foundation.CFBridgingRelease
import platform.Foundation.CFBridgingRetain
import platform.Foundation.NSData
import platform.Foundation.NSDictionary
import platform.Foundation.NSHTTPURLResponse
import platform.Foundation.NSString
import platform.Foundation.NSURL
import platform.Foundation.NSURLRequest
import platform.Foundation.NSURLSession
import platform.Foundation.dataTaskWithRequest
import platform.Foundation.valueForKey
import platform.ImageIO.CGImageSourceCopyPropertiesAtIndex
import platform.ImageIO.CGImageSourceCreateImageAtIndex
import platform.ImageIO.CGImageSourceCreateWithData
import platform.ImageIO.CGImageSourceGetCount
import platform.ImageIO.CGImageSourceRef
import platform.ImageIO.kCGImagePropertyGIFDelayTime
import platform.ImageIO.kCGImagePropertyGIFDictionary
import platform.UIKit.UIImage
import kotlin.coroutines.resume

/*
* Temporary workaround to render Gifs in iOS while Coil or Kamel doesn't add real support to it.
*
* Source code found in kotlin forum
* https://slack-chats.kotlinlang.org/t/16598499/has-anyone-been-able-to-implement-a-gif-renderer-on-ios#55fc02fe-a5fe-4731-b8b8-2bb35b7c9d11
* */
suspend fun gifImageWithURL(url: String): UIImage? {
    val data = loadGif(url)
    return createGifImage(data)
}

private suspend fun loadGif(url: String): NSData? {
    return suspendCancellableCoroutine { cont ->
        val request = NSURLRequest.requestWithURL(NSURL(string = url))
        NSURLSession.sharedSession.dataTaskWithRequest(
            request = request,
            completionHandler = { data, response, error ->
                if (error == null && response != null && data != null) {
                    if ((response as NSHTTPURLResponse).statusCode == 200L) {
                        cont.resume(data)
                    } else {
                        cont.resume(null)
                    }
                } else {
                    cont.resume(null)
                }
            }
        ).resume()
    }
}

@OptIn(ExperimentalForeignApi::class)
private fun createGifImage(data: NSData?): UIImage? {
    return runCatching {
        val dataRef = CFBridgingRetain(data) as? CFDataRef
        val source = CGImageSourceCreateWithData(dataRef, null) ?: return null
        val count = CGImageSourceGetCount(source).toInt()
        val images = mutableListOf<CGImageRef>()
        val delays = mutableListOf<Double>()

        for (i in 0 until count) {
            val image = CGImageSourceCreateImageAtIndex(source, i.toULong(), null)
            if (image != null) {
                images.add(image)
            }

            val delaySeconds = delayForImageAtIndex(i, source)
            delays.add(delaySeconds * 1000.0) // s to ms
        }

        val duration = delays.sum()
        val gcd = gcdForList(delays)
        val frames = mutableListOf<UIImage>()

        for (i in 0 until count) {
            val frame = UIImage.imageWithCGImage(images[i])
            val frameCount = (delays[i] / gcd).toInt()
            for (f in 0 until frameCount) {
                frames.add(frame)
            }
        }

        val animation = UIImage.animatedImageWithImages(frames, duration / 1000.0) ?: return null
        animation
    }.onFailure { it.printStackTrace() }.getOrNull()
}

@OptIn(ExperimentalForeignApi::class)
private fun delayForImageAtIndex(index: Int, source: CGImageSourceRef): Double {
    var delay: Double

    val cfProperties = CGImageSourceCopyPropertiesAtIndex(source, index.toULong(), null)
    val gifKey = (CFBridgingRelease(kCGImagePropertyGIFDictionary) as NSString).toString()
    val gifInfo =
        (CFBridgingRelease(cfProperties) as? NSDictionary)?.valueForKey(gifKey) as? NSDictionary

    delay =
        gifInfo?.valueForKey((CFBridgingRelease(kCGImagePropertyGIFDelayTime) as NSString).toString()) as? Double
            ?: 0.0

    if (delay < 0.1) {
        delay = 0.1
    }

    return delay
}

private fun gcdForPair(_a: Int?, _b: Int?): Int {
    var a = _a
    var b = _b
    if (b == null || a == null) {
        return b ?: (a ?: 0)
    }

    if (a < b) {
        val c = a
        a = b
        b = c
    }

    var rest: Int
    while (true) {
        rest = a!! % b!!
        if (rest == 0) {
            return b
        } else {
            a = b
            b = rest
        }
    }
}

private fun gcdForList(list: List<Double>): Double {
    if (list.isEmpty()) return 1.0
    var gcd = list[0]
    list.onEach {
        gcd = gcdForPair(it.toInt(), gcd.toInt()).toDouble()
    }
    return gcd
}
