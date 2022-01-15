import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

private const val INPUT = "метод"
private const val P = 5
private const val Q = 7
private const val H0 = 8

class X590HashTest {
    @Test
    fun `hash test`() {
        assertEquals(expected = 1, actual = x590Hash(p = P, q = Q, h0 = H0, input = INPUT))
        assertNotEquals(1, x590Hash(p = P, q = 11, h0 = H0, input = INPUT))
    }
}