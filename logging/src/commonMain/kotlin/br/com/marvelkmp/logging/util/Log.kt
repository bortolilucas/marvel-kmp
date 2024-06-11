package br.com.marvelkmp.logging.util

import io.github.aakira.napier.Napier

object Log {
    fun v(message: String, throwable: Throwable? = null, tag: String? = null) {
        Napier.v(message, throwable, tag)
    }

    fun d(message: String, throwable: Throwable? = null, tag: String? = null) {
        Napier.d(message, throwable, tag)
    }

    fun i(message: String, throwable: Throwable? = null, tag: String? = null) {
        Napier.i(message, throwable, tag)
    }

    fun e(message: String, throwable: Throwable? = null, tag: String? = null) {
        Napier.e(message, throwable, tag)
    }
}