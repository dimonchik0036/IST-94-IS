import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

private const val DECODED = "метод"
private const val ENCODED = "7 25 24 5 49"
private const val E = 7
private const val D = 23
private const val N = 55

class RsaTest {
    @Test
    fun `test encode`() {
        val encoded = rsaEncode(e = E, n = N, input = DECODED)
        assertEquals(expected = ENCODED, actual = encoded)
        assertNotEquals(
            illegal = ENCODED,
            actual = rsaEncode(e = E + 1, n = N, input = DECODED),
        )

        assertNotEquals(
            illegal = ENCODED,
            actual = rsaEncode(e = E, n = N + 1, input = DECODED),
        )
    }

    @Test
    fun `test decode`() {
        val decoded = rsaDecode(d = D, n = N, input = ENCODED)
        assertEquals(expected = DECODED, actual = decoded)
        assertNotEquals(
            illegal = DECODED,
            actual = rsaDecode(d = D, n = N + 1, input = ENCODED),
        )

        assertNotEquals(
            illegal = DECODED,
            actual = rsaDecode(d = D + 1, n = N, input = ENCODED),
        )
    }
}