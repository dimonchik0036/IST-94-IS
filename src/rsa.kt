fun main() {
    val input = "метод"
    val e = 7
    val n = 55
    val d = 23
    val encoded = rsaEncode(e, n, input)
    println(encoded)
    println(rsaDecode(d, n, encoded))
}

fun rsaEncode(e: Int, n: Int, input: String): String {
    val map = LETTERS_AND_NUMBERS.asMap()
    return input.asSequence().joinToString(separator = " ") {
        val charToEncode = map[it] ?: it.code
        powByMod(number = charToEncode, pow = e, mod = n).toString()
    }
}

fun rsaDecode(d: Int, n: Int, input: String): String {
    val vocabulary = LETTERS_AND_NUMBERS
    return input.splitToSequence(" ").joinToString(separator = "") {
        val index = powByMod(number = it.toInt(), pow = d, mod = n)
        vocabulary.getOrElse(index) { index.toChar() }.toString()
    }
}