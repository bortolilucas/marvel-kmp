package features.character.domain.utils

fun String.toHttpsUrl() = this.replace("http", "https")