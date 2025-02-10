import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@ExperimentalTime
fun main() {
    println("Arrays and Strings")

    println("Unique Strings Without DS")
    val cases = listOf(
        "  ",
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZZ",
        "AabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",
        "",
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZa",
    )
    cases.forEach {
        val duration = measureTime {
            println(it + " -> " + allUniqueWithoutDS(it))
        }
        println("duration: ${duration.inWholeMilliseconds}")
    }

    println("Unique Strings With DS")

    cases.forEach {
        allUniqueWithDS(it)
        val duration = measureTime {
            println(it + " -> " + allUniqueWithDS(it))
        }
        println("duration: ${duration.inWholeMilliseconds}")
    }
}

fun allUniqueWithoutDS(str: String): Boolean {
    val countOfStrings = IntArray(128) {
        0
    }
    str.forEach {
        val currentValue = countOfStrings[it.toInt()]
        countOfStrings[it.toInt()] = currentValue + 1
        if (countOfStrings[it.toInt()] > 1) {
            return false
        }
    }
    return true
}

fun allUniqueWithDS(str: String): Boolean {
    val mapOfCharCount = mutableMapOf<Char, Int>()
    str.forEach {
        var count = mapOfCharCount[it] ?: 0
        mapOfCharCount[it] = ++count
        if (count > 1)
            return false
    }
    println(mapOfCharCount)
    return true
}