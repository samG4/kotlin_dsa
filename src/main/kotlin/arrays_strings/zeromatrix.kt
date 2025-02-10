package arrays_strings

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 0),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )

    val matrix2 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 0, 6),
        intArrayOf(7, 8, 9)
    )

    zeroMatrix(matrix2)

    debugMatrix(matrix2)
}


private fun zeroMatrix(input: Array<IntArray>) {
    val listOfZeroIndex = mutableListOf<Pair<Int, Int>>()

    input.forEachIndexed { index, array ->
        array.forEachIndexed { j, value ->
            if (input[index][j] == 0) {
                listOfZeroIndex.add(Pair(index, j))
            }
        }
    }

    listOfZeroIndex.forEach { element ->
        val i = element.first
        val j = element.second
        val size = input.size
        var k = 0;
        while (i < size && k < size) {
            input[i][k++] = 0
        }
        k = 0;
        while (j < size && k < size) {
            input[k++][j] = 0
        }
    }


}


