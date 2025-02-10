package arrays_strings


fun debugMatrix(input: Array<IntArray>) {
    input.forEach { layer ->
        layer.forEach {
            print(it)
            print(", ")
        }
        println()
    }
    println()
}


fun debugMatrixIndex(input: Array<IntArray>) {
    input.forEachIndexed { iIndex, layer ->
        layer.forEachIndexed { jIndex, _ ->
            print("[$iIndex][$jIndex] ")
        }
        println()
    }
    println()
}