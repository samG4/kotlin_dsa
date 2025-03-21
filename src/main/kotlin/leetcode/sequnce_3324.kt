package leetcode

fun main() {
    val solution = Solution()
    val listOfTarget = listOf<String>("ab")
    val result = listOfTarget.map {
        solution.stringSequence(it)
    }.toList()
    println(listOfTarget)
    println(result)
}

class Solution {
    fun stringSequence(target: String): List<String> {
        if(target.isEmpty()) return emptyList()
        val seq = mutableListOf<String>()
        val stringBuilder = java.lang.StringBuilder()
        presskey1(stringBuilder)
        seq.add(stringBuilder.toString())
        var i = 1;
        while(i<=target.length) {
            if(seq.last() == target) {
                break;
            }
            if(stringBuilder.last() == target[i-1]) {
                presskey1(stringBuilder)
                i++
            } else {
                presskey2(stringBuilder)
            }
            seq.add(stringBuilder.toString())
        }
        return seq
    }

    fun presskey1(strBuilder: StringBuilder) {
        strBuilder.append("a")
    }

    fun presskey2(strBuilder: StringBuilder) {
        var lastKey = strBuilder.last()
        lastKey = lastKey.plus(1)
        val lastIndex = strBuilder.lastIndex
        strBuilder.deleteCharAt(lastIndex)
        strBuilder.append(lastKey)
    }
}
