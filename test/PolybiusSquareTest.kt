import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

private const val DECODED = "я изучаю методы защиты информации"
private const val ENCODED = "65 242344531164 322143341562 231155244362 24334534413211522424"
private const val COLUMNS = 5
private const val ROWS = 6

class PolybiusSquareTest {
    @Test
    fun `test encode`() {
        val encoded = polybiusSquareEncode(columns = COLUMNS, rows = ROWS, input = DECODED)
        assertEquals(expected = ENCODED, actual = encoded)
        assertNotEquals(
            illegal = ENCODED,
            actual = polybiusSquareEncode(columns = ROWS, rows = COLUMNS, input = DECODED),
        )
    }

    @Test
    fun `test decode`() {
        val decoded = polybiusSquareDecode(columns = COLUMNS, rows = ROWS, input = ENCODED)
        assertEquals(expected = DECODED, actual = decoded)
        assertNotEquals(
            illegal = DECODED,
            actual = polybiusSquareDecode(columns = ROWS, rows = COLUMNS, input = ENCODED),
        )
    }
}
