package arrays_strings

fun main() {
    print(checkPermutation("Unique Strings Without DS", "DS Without Strings Unique"));
}

fun checkPermutation(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) return false
    val str1Map = mutableMapOf<Char, Int>()
    str1.forEach {
        val currentCount = str1Map[it] ?: 0
        str1Map[it] = currentCount + 1
    }

    str2.forEach {
        val currentCount = str1Map[it] ?: -1
        if (currentCount <= 0)
            return false
        str1Map[it] = currentCount - 1
    }


    val anyDifferentChar = str1Map.any { it.value != 0 }
    return !anyDifferentChar
}