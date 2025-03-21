package trees

import java.util.*

fun main() {
    val test = intArrayOf(1,2,3,4,5,6,7)
    val tree = createMinimalTree(test)
    printTree(tree)
}

fun createMinimalTree(sortedArray: IntArray, startIndex: Int = 0, endIndex: Int = sortedArray.lastIndex): TreeNode<Int>? {
    if (startIndex > endIndex) return null

    val halfIndex = (startIndex + endIndex) / 2
    val node = TreeNode(sortedArray[halfIndex])

    node.left = createMinimalTree(sortedArray, startIndex, halfIndex - 1)
    node.right = createMinimalTree(sortedArray, halfIndex + 1, endIndex)
    return node
}


fun <T> printTree(root: TreeNode<T>?) {
    if (root == null) return

    val queue: Queue<Pair<TreeNode<T>, Int>> = LinkedList()
    queue.add(root to 0)

    val levels = mutableMapOf<Int, MutableList<TreeNode<T>?>>()
    var maxLevel = 0

    while (queue.isNotEmpty()) {
        val (node, level) = queue.poll()
        levels.computeIfAbsent(level) { mutableListOf() }.add(node)
        maxLevel = maxOf(maxLevel, level)

        node.left?.let { queue.add(it to level + 1) }
        node.right?.let { queue.add(it to level + 1) }
    }

    for (level in 0..maxLevel) {
        val nodes = levels[level] ?: continue
        val space = "t".repeat(((maxLevel - level) * 2))

        println(space + nodes.joinToString("x y") { it?.value.toString() })

        if (level < maxLevel) {
            val branches = nodes.joinToString(" z ") {
                when {
                    it?.left != null && it?.right != null -> "/ \\"
                    it?.left != null -> "/  "
                    it?.right != null -> "   \\"
                    else -> " a "
                }
            }
            println(space + branches)
        }
    }
}
