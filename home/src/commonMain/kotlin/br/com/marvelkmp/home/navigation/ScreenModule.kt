package br.com.marvelkmp.home.navigation

import cafe.adriel.voyager.core.registry.ScreenRegistry

private typealias ScreenModule = ScreenRegistry.() -> Unit

public fun screenModule(block: ScreenModule): ScreenModule = { block() }