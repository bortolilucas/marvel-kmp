package br.com.marvelkmp.core.presentation.util.gif

import platform.UIKit.UIImageView

interface GifHelper {
    fun gifImageWithURL(url: String): UIImageView
    fun gitImageWithName(name: String): UIImageView
}
