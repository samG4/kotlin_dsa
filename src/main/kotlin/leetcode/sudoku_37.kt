package leetcode

//fun main() {
//    // Example Sudoku puzzle (0 = empty cell)
//    val board = arrayOf(
//        intArrayOf(9, 0, 8, 0, 0, 0, 0, 6, 0),
//        intArrayOf(5, 3, 0, 0, 7, 0, 0, 0, 0),
//        intArrayOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
//        intArrayOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
//        intArrayOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
//        intArrayOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
//        intArrayOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
//        intArrayOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
//        intArrayOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
//    )
//    printBoard(board);
//
//    println()
//    val t = System.currentTimeMillis()
//    val solved = solve(board)
//    println("time taken - ${System.currentTimeMillis() - t}")
//    if (solved) {
//        println("Sudoku solved successfully!")
//        printBoard(board)
//    } else {
//        println("No solution exists for the given puzzle.")
//        printBoard(board)
//    }
//}


private fun solve(board: Array<IntArray>): Boolean {
    for (row in 0..8) {
        for (col in 0..8) {
            if (board[row][col] == 0) {
                // Try each candidate number
                for (num in 1..9) {
                    if (isValid(board, row, col, num)) {
                        board[row][col] = num
                        // If this leads to a solution, return true
                        if (solve(board)) return true
                        printBoard(board);
                        // Otherwise, reset and try another number
                        board[row][col] = 0
                    }
                }
                // If no valid number found, backtrack
                return false
            }
        }
    }
    // If we never hit an empty cell, puzzle is solved
    return true
}

private fun isValid(board: Array<IntArray>, row: Int, col: Int, num: Int): Boolean {
    // Row check
    for (c in 0..8) {
        if (board[row][c] == num) return false
    }
    // Column check
    for (r in 0..8) {
        if (board[r][col] == num) return false
    }
    // 3×3 sub-box check
    val boxRowStart = (row / 3) * 3
    val boxColStart = (col / 3) * 3
    for (r in boxRowStart until boxRowStart + 3) {
        for (c in boxColStart until boxColStart + 3) {
            if (board[r][c] == num) return false
        }
    }
    return true
}

fun printBoard(board: Array<IntArray>) {
    for (r in 0..8) {
        // Draw a horizontal separator every 3 rows (except at the top)
        if (r % 3 == 0 && r != 0) {
            println("---------------------")
        }
        for (c in 0..8) {
            // Draw a vertical separator every 3 columns (except at the leftmost)
            if (c % 3 == 0 && c != 0) print("| ")
            print(board[r][c].toString() + " ")
        }
        println()
    }
}

