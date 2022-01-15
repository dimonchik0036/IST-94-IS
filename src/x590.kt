fun main() {
    val input = "метод"
    val p = 5
    val q = 7
    val h0 = 8
    println(x590Hash(p, q, h0, input))
}

fun x590Hash(p: Int, q: Int, h0: Int, input: String): Int {
    val n = p * q
    val map = LETTERS_AND_NUMBERS.asMap()
    return input.fold(h0) { prev, char ->
        val charToEncode = map[char] ?: char.code
        powByMod(number = prev + charToEncode, pow = 2, mod = n)
    }
}
