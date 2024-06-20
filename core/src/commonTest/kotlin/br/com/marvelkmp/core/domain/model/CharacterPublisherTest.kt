package br.com.marvelkmp.core.domain.model

import kotlin.test.Test
import kotlin.test.assertEquals

class CharacterPublisherTest {
    @Test
    fun `should parse Marvel Comics`() {
        val publisher = "Marvel Comics"

        val expectedPublisher = CharacterPublisher.Marvel
        val actualPublisher = CharacterPublisher.parse(publisher)

        assertEquals(expectedPublisher, actualPublisher)
    }

    @Test
    fun `should parse Other`() {
        val publisher = "DC Comics"

        val expectedPublisher = CharacterPublisher.Other(publisher)
        val actualPublisher = CharacterPublisher.parse(publisher)

        assertEquals(expectedPublisher, actualPublisher)
    }
}