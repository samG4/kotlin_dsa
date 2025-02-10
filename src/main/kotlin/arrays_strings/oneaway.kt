package arrays_strings

import kotlin.math.abs


fun main() {
    println(isOneAway("abcdef", "abcdef".reversed()))
    println(isOneAwayWithoutPositon("abcdef", "abcdef".reversed()))
}

fun isOneAwayWithoutPositon(str1: String, str2: String): Boolean {
    if (abs(str1.length - str2.length) > 1)
        return false
    val mapOfStr1 = mutableMapOf<Char, Int>()
    str1.forEach {
        mapOfStr1[it] = mapOfStr1.getOrDefault(it, 0) + 1
    }
    str2.forEach {
        mapOfStr1[it] = mapOfStr1.getOrDefault(it, 0) - 1
    }

    val nonZeroCharacs = mapOfStr1.filterValues { it != 0 }

    if (nonZeroCharacs.size > 2 || nonZeroCharacs.any { abs(it.value) > 1 }) return false
    return true
}

fun isOneAway(str1: String, str2: String): Boolean {
    if (abs(str1.length - str2.length) > 1)
        return false
    //check for replacement
    val (bigString, smallString) = if (str1.length > str2.length) {
        Pair(str1, str2)
    } else if (str2.length > str1.length) {
        Pair(str2, str1)
    } else {
        Pair(null, null)
    }
    if (bigString == null || smallString == null) {
        // only replacement is possible
        var foundDiff = 0
        str1.forEachIndexed { index, charac ->
            if (charac != str2[index]) foundDiff++
            if (foundDiff > 1)
                return false
        }
        return true
    } else {
        // removal or insertion is possible
        var bigIndex = 0
        var smallIndex = 0
        var foundDiff = 0
        while(bigIndex < bigString.length && smallIndex < smallString.length ) {
            if(bigString[bigIndex] != smallString[smallIndex]) {
                foundDiff++
            }
            if(foundDiff > 1) return false
            bigIndex++
            smallIndex++
        }
    }

    return true
}