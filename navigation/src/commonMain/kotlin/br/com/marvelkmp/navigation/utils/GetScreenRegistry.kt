package br.com.marvelkmp.navigation.utils

import cafe.adriel.voyager.core.registry.ScreenProvider
import cafe.adriel.voyager.core.registry.ScreenRegistry

fun getScreenRegistry(provider: ScreenProvider) = ScreenRegistry.get(provider)