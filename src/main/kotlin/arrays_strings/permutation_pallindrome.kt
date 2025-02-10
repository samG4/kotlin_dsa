package arrays_strings


fun main() {
    println(permutationPalindrome("tact coa"))
    println(permutationPalindrome("racecar"))
    println(permutationPalindrome("hello"))
    println(permutationPalindrome("aabbc"))
    println(permutationPalindrome("Able was I ere I saw Elba"))
}

fun permutationPalindrome(input: String) : Boolean {
    //any string is palindrome when reverse string is same as orignal
    //in permutation any combo is possible
    //to be in pallindrom at most one charact can be odd number count
    //all the charac should be in even

    val mapOfCharCount = mutableMapOf<Char, Int>()

    input.lowercase().forEach {
        if(it != ' ') {
            mapOfCharCount[it] = mapOfCharCount.getOrDefault(it, 0) + 1
        }
    }
    val numberOfOddCharacters = mapOfCharCount.filterValues { it % 2 != 0 }.size
    return numberOfOddCharacters <= 1
}