package br.com.marvelkmp.navigation

import cafe.adriel.voyager.core.registry.ScreenRegistry

private typealias ScreenModule = ScreenRegistry.() -> Unit

fun screenModule(block: ScreenModule): ScreenModule = { block() }