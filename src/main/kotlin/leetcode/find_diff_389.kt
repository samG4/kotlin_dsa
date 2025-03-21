package leetcode

class FindDiff {
    fun findTheDifference(s: String, t: String): Char {
        val countS: Map<Char, Int> = s.groupingBy { it }.eachCount()
        val countT: Map<Char, Int> = t.groupingBy { it }.eachCount()
        val diff = (countS.keys + countT.keys)
            .associateWith { char ->
                (countS[char] ?: 0) - (countT[char] ?: 0)
            }
            .filterValues { it != 0 }.keys.firstOrNull()
        print(diff)
        return diff ?: ' '
    }

    fun findTheDifference2(s: String, t: String): Char {
        var xorResult = 0
        for (char in s) xorResult = xorResult xor char.code
        for (char in t) xorResult = xorResult xor char.code
        return xorResult.toChar()
    }

}

fun main() {
    val test = FindDiff()
    print(test.findTheDifference2("", "a"))
}