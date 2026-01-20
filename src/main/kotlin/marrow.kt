data class marrow (val name: String, val type: Type)

enum class Type {
    NORMAL, HTML
}

fun doPrintWithJobDelay(data: marrow, onDone: () -> Unit) {
    println(data.name)
    Thread.sleep(1000)
    onDone()
}

fun main() {
    var currentIndex = 0
    val testCases = listOf(
        marrow("test1", Type.NORMAL),
        marrow("test2", Type.NORMAL),
        marrow("test3", Type.HTML),
        marrow("test4", Type.HTML),
        marrow("test5", Type.HTML),
        marrow("test6", Type.NORMAL),
        marrow("test7", Type.HTML),
        marrow("test8", Type.HTML),
    )
    repeat(testCases.size) { index ->
        if (index == currentIndex) {
            val description = testCases[index]
            when (description.type) {
                 Type.HTML -> {
                     doPrintWithJobDelay(description, onDone = {currentIndex++})
                }
                Type.NORMAL -> {
                    println("doing normal task")
                }
            }
        }
    }
}