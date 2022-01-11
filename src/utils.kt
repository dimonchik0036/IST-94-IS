const val LETTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
const val LETTERS_AND_NUMBERS = "$LETTERS 0123456789"

internal fun String.asMap(): Map<Char, Int> = withIndex().associate { it.value to it.index }
