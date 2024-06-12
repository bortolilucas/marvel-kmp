package br.com.marvelkmp.core.domain.utils

fun String.toHttpsUrl() = this.replace("http", "https")