import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

private const val DECODED = "метод"
private const val ENCODED = "22 30 8 20 31"
private const val X = 10
private const val G = 8
private const val Y = 11
private const val P = 37
private const val K = 5

class ElgamalTest {
    @Test
    fun `test encode`() {
        val encoded = elgamalEncode(y = Y, p = P, k = K, input = DECODED)
        assertEquals(expected = ENCODED, actual = encoded)
        assertNotEquals(
            illegal = ENCODED,
            actual = elgamalEncode(y = Y + 1, p = P, k = K, input = DECODED),
        )

        assertNotEquals(
            illegal = ENCODED,
            actual = elgamalEncode(y = Y, p = P + 1, k = K, input = DECODED),
        )

        assertNotEquals(
            illegal = ENCODED,
            actual = elgamalEncode(y = Y, p = P, k = K + 1, input = DECODED),
        )
    }

    @Test
    fun `test decode`() {
        val decoded = elgamalDecode(x = X, g = G, p = P, k = K, input = ENCODED)
        assertEquals(expected = DECODED, actual = decoded)
        assertNotEquals(
            illegal = DECODED,
            actual = elgamalDecode(x = X + 1, g = G, p = P, k = K, input = ENCODED),
        )

        assertNotEquals(
            illegal = DECODED,
            actual = elgamalDecode(x = X, g = G + 1, p = P, k = K, input = ENCODED),
        )
    }
}