fun main() {
    val input = "я изучаю методы защиты информации"
    val columns = 5
    val rows = 6
    println(polybiusSquareEncode(columns, rows, input))

    val square = mutableMapOf<String, String>()
    processTable(columns, rows) { letter, column, row ->
        val key = "$row$column"
        square.merge(key, letter.toString()) { old, new -> "$old/$new" }
    }

    println(
        square.entries.chunked(columns).joinToString(separator = "\n") { line ->
            line.joinToString(separator = " ") {
                "${it.value}->${it.key}"
            }
        }
    )
}

private val baseLetters = listOf(
    "а",
    "б",
    "в",
    "г",
    "д",
    "ёе",
    "ж",
    "з",
    "йи",
    "к",
    "л",
    "м",
    "н",
    "о",
    "п",
    "р",
    "с",
    "т",
    "у",
    "ф",
    "х",
    "ц",
    "ч",
    "ш",
    "щ",
    "ъь",
    "ы",
    "э",
    "ю",
    "я"
)

private fun processTable(columns: Int, rows: Int, processor: (letter: Char, column: Int, row: Int) -> Unit) {
    if (columns < 0 || columns * rows != baseLetters.size) error("columns * rows must be equals to ${baseLetters.size}")
    for (row in 0 until rows) {
        for (column in 0 until columns) {
            for (letter in baseLetters[columns * row + column]) {
                processor(letter, column + 1, row + 1)
            }
        }
    }
}

fun polybiusSquareEncode(columns: Int, rows: Int, input: String): String {
    val table = mutableMapOf<Char, String>()
    processTable(columns, rows) { letter, column, row ->
        table[letter] = "$row$column"
    }

    return buildString {
        for (char in input) {
            append(table[char] ?: char)
        }
    }
}

fun polybiusSquareDecode(columns: Int, rows: Int, input: String): String {
    val encodeTable = mutableMapOf<Char, String>()
    val decodeTable = mutableMapOf<String, Char>()
    processTable(columns, rows) { letter, column, row ->
        decodeTable["$row$column"] = letter
        encodeTable[letter] = "$row$column"
    }

    return buildString {
        var lastChar: Char? = null
        for (char in input) {
            if (!char.isDigit() && char !in encodeTable) {
                if (lastChar != null) {
                    append(lastChar)
                    lastChar = null
                }

                append(char)
                continue
            }

            if (lastChar == null) {
                lastChar = char
                continue
            }

            val key = "$lastChar$char"
            append(decodeTable[key] ?: key)
            lastChar = null
        }
    }
}
