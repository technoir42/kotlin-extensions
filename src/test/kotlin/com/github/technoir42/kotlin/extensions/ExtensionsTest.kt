package com.github.technoir42.kotlin.extensions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@Suppress("TestFunctionName")
class ExtensionsTest {
    @Test
    fun List_replaceIf() {
        assertEquals(listOf(1, 1, 3, 2), listOf(1, 2, 3, 4).replaceIf({ it % 2 == 0 }) { it / 2 })
        assertEquals(listOf(1, 2, 3, 4), listOf(1, 2, 3, 4).replaceIf({ false }) { 0 })
    }

    @Test
    fun Sequence_startWith() {
        assertEquals(listOf(1, 2, 3, 4), sequenceOf(2, 3, 4).startWith(1).toList())
    }

    @Test
    fun Pair_plus() {
        assertEquals(Triple(1.0, 2, "3"), Pair(1.0, 2) + "3")
    }

    @Test
    fun String_nullIfEmpty() {
        assertEquals(null, (null as String?).nullIfEmpty())
        assertEquals(null, "".nullIfEmpty())
        assertEquals("abc", "abc".nullIfEmpty())
    }

    @Test
    fun String_truncate() {
        assertEquals("abc", "abc".truncate(5))
        assertEquals("abcde", "abcde".truncate(5))
        assertEquals("abcde...", "abcdef".truncate(5))

        val exception = assertThrows<IllegalArgumentException> { "abc".truncate(0) }
        assertEquals("maxLength 0 must be greater than zero", exception.message)
    }
}
