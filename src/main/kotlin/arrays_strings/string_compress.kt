package arrays_strings

import java.lang.StringBuilder

fun main() {
    println(stringCompress("aaa"))
    println(stringCompress("aabcccccaaa"))
    println(stringCompress("aabb"))
    println(stringCompress("aaabb"))
    println(stringCompress("a"))
}

fun stringCompress(input: String): String {
    if (input.isEmpty() || input.length <= 2) return input

    val output = StringBuilder()
    var i = 0
    var currentChar = input[0]
    output.append(currentChar)
    //aaa -> a3
    var count = 1
    while (i < input.length - 1) {
        if (currentChar == input[i + 1]) {
            ++count
        } else {
            output.append(count)
            count = 1
            currentChar = input[i + 1]
            output.append(currentChar)
        }
        i++
    }
    output.append(count)
    return if (input.length <= output.toString().length) input else output.toString()
}