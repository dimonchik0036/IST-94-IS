const val LETTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
const val LETTERS_AND_NUMBERS = "$LETTERS 0123456789"

internal fun String.asMap(): Map<Char, Int> = withIndex().associate { it.value to it.index }

internal fun powByMod(number: Int, pow: Int, mod: Int): Int {
    var result = 1
    for (round in 0 until pow) {
        result = result * number % mod
    }

    return result
}