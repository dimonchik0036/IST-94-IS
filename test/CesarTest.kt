import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

private const val DECODED = "я изучаю методы защиты информации"
private const val ENCODED = "в лкцъгб пзхсжю кгьлхю лрчсупгщлл"
private const val CESAR_KEY = 3

class CesarTest {
    @Test
    fun `test encode`() {
        val encoded = cesarEncode(key = CESAR_KEY, input = DECODED)
        assertEquals(expected = ENCODED, actual = encoded)
        assertNotEquals(illegal = ENCODED, actual = cesarEncode(CESAR_KEY + 1, DECODED))
    }

    @Test
    fun `test decode`() {
        val decoded = cesarDecode(key = CESAR_KEY, encoded = ENCODED)
        assertEquals(expected = DECODED, actual = decoded)
        assertNotEquals(illegal = DECODED, actual = cesarDecode(CESAR_KEY + 1, ENCODED))
    }
}