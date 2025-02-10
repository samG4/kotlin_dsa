package arrays_strings

fun main() {
    val input = "Mr John Smith    s                     ".toCharArray()
    makeUrlFromString(input)
    print(input)
}


fun makeUrlFromString(chars: CharArray) {
    val trueLength = chars.indexOfLast { it != ' ' } + 1

    val replaceLength = 3 // "%20" has 3 characters
    var finalCharLength = chars.size - 1  // Start from last index of array

    // Process characters from end to start
    for (i in (trueLength - 1) downTo 0) {
        if (chars[i] == ' ') {
            // Replace space with "%20"
            chars[finalCharLength] = '0'
            chars[finalCharLength - 1] = '2'
            chars[finalCharLength - 2] = '%'
            finalCharLength -= replaceLength
        } else {
            // Copy non-space character
            chars[finalCharLength] = chars[i]
            finalCharLength--
        }
    }
}