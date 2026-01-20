package leetcode


fun main() {
    val num1 = intArrayOf(10, 20, 30, 0)
    val num2 = intArrayOf(10)

    merge(num1, 3, num2, 1)
    print("[")
    num1.forEachIndexed { i, item ->
        print(item.toString())
        if(i != num1.lastIndex) {
            print(", ")
        }
    }
    print("]")
    //merge()
}

fun merge(num1: IntArray, m: Int, num2: IntArray, n: Int): Unit {
    var i = m - 1
    var j = n - 1
    var k = m + n - 1

    while(i>=0 && j>=0) {
        if(num2[j] > num1[i]) {
            num1[k] = num2[j]
            j--
        } else if (num1[i] >= num2[j]){
            num1[k] = num1[i]
            i--
        }
        k--
    }
    while(j>=0) {
        num1[k] = num2[j]
        k--
        j--
    }
}


fun printArray(array: IntArray) {
    print("[")
    array.forEachIndexed { i, item ->
        print(item.toString())
        if(i != array.lastIndex) {
            print(", ")
        }
    }
    print("]")
}