fun main() {
    val input = "метод"
    val x = 10
    val g = 8
    val y = 11
    val p = 37
    val k = 5
    val encoded = elgamalEncode(y = y, p = p, k = k, input = input)
    println(encoded)
    println(elgamalDecode(x = x, g = g, p = p, k = k, input = encoded))
}

fun elgamalEncode(y: Int, p: Int, k: Int, input: String): String {
    val vocabulary = LETTERS_AND_NUMBERS.asMap()
    val key = powByMod(number = y, pow = k, mod = p)
    return input.asSequence().joinToString(separator = " ") {
        val charToEncode = vocabulary[it] ?: it.code
        charToEncode.xor(key).toString()
    }
}

fun elgamalDecode(x: Int, g: Int, p: Int, k: Int, input: String): String {
    val vocabulary = LETTERS_AND_NUMBERS
    val a = powByMod(number = g, pow = k, mod = p)
    val key = powByMod(number = a, pow = x, mod = p)
    return input.splitToSequence(" ").joinToString(separator = "") {
        val index = key.xor(it.toInt())
        vocabulary.getOrElse(index) { index.toChar() }.toString()
    }
}