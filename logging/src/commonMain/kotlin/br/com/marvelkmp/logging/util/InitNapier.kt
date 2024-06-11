package br.com.marvelkmp.logging.util

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

fun initNapier() {
    Napier.base(DebugAntilog())
}