package br.com.marvelkmp.network.core.utils

import MarvelKmp.network.core.BuildConfig
import br.com.marvelkmp.network.core.model.GenerateHashReturn
import com.ionspin.kotlin.bignum.integer.BigInteger
import com.ionspin.kotlin.bignum.integer.Sign
import io.ktor.util.date.getTimeMillis
import io.ktor.utils.io.core.toByteArray
import org.kotlincrypto.hash.md.MD5

fun generateHash(): GenerateHashReturn {
    val timestamp = getTimeMillis().toString()
    val hashInput = timestamp + BuildConfig.PRIVATE_KEY + BuildConfig.PUBLIC_KEY
    val md5Digest = MD5()
    val hash =
        BigInteger.fromByteArray(md5Digest.digest(hashInput.toByteArray()), Sign.POSITIVE)
            .toString(16)
            .padStart(32, '0')

    return GenerateHashReturn(hash, timestamp)
}
