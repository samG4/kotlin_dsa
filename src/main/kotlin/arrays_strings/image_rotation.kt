package arrays_strings


fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(4, 5, 6, 4),
        intArrayOf(7, 8, 9, 4),
        intArrayOf(7, 8, 9, 4),
    )

    println("Original Matrix:")
    debugMatrix(matrix)
//    debugMatrixIndex(matrix)
//    rotateMatrixClock(matrix) // ->
//    debugMatrix(matrix)

    rotateMatrixAntiClock(matrix) // <-
    debugMatrix(matrix)

//    println("\n\nRotated Matrix:")
//    debugMatrix(matrix)
}



fun rotateMatrixClock(input: Array<IntArray>) {
    // ->
    val size = input.size

    for (i in 0 until size / 2) {
        val lastLayer = size - 1 - i //3-1-0: 2
        for (j in lastLayer downTo i ) {
            val targetIndex = j - i // 2-0: 2
            val temp = input[i][j] // -> 00
            input[i][j] = input[lastLayer][i] // [0][0]=[2][0]
            input[lastLayer][i] = input[lastLayer][lastLayer - targetIndex]// [2][0]=[2][2]
            input[lastLayer][lastLayer - targetIndex] = input[j][lastLayer] //[2][2] -> [0][2]
            input[j][lastLayer] = temp//20 -> 00
        }
    }
}


fun rotateMatrixAntiClock(matrix: Array<IntArray>) {
    val n = matrix.size

    for (layer in 0 until n / 2) {
        val first = layer
        val last = n - 1 - layer

        for (i in first until last) {
            val offset = i - first
            // 4-way Swap
            val top = matrix[first][i] // Save top

            matrix[first][i] = matrix[last - offset][first] // Left → Top

            matrix[last - offset][first] = matrix[last][last - offset] // Bottom → Left
            matrix[last][last - offset] = matrix[i][last] // Right → Bottom
            matrix[i][last] = top // Top → Right

//            println("$first $i ->${last-offset} $first ->$last ${last-offset} ->$i $last ->")
//            debugMatrix(matrix)
        }
    }
}