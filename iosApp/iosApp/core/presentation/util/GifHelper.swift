import ComposeApp
import Gifu
import UIKit

class IOSGifHelper : GifHelper {
    func gifImageWithURL(url: String) -> UIImageView {
        let gifView = GIFImageView()
        
        gifView.animate(withGIFURL: URL(string: url)!)
        
        return gifView
    }
    
    func gitImageWithName(name: String) -> UIImageView {
        let gifView = GIFImageView()
        
        gifView.animate(withGIFNamed: name)
        
        return gifView
    }
}
