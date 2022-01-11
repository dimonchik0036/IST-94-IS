fun main() {
    val input = "я изучаю методы защиты информации"
    val key = 3
    println(cesarEncode(key, input))
}

fun cesarEncode(key: Int, input: String): String = cesarCoder(encode = true, key, input)
fun cesarDecode(key: Int, encoded: String): String = cesarCoder(encode = false, key, encoded)

private fun cesarCoder(encode: Boolean, key: Int, input: String): String {
    val alignedKey = key % LETTERS.length
    val letterToIndexMap = LETTERS.asMap()
    return buildString {
        for (char in input) {
            val baseIndex = letterToIndexMap[char]
            if (baseIndex == null) {
                append(char)
            } else {
                val shift = if (encode) alignedKey else -alignedKey
                append(LETTERS[(baseIndex + shift + LETTERS.length) % LETTERS.length])
            }
        }
    }
}