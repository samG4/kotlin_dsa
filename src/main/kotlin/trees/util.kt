package trees

class TreeNode<T>(val value: T) {
    var left: TreeNode<T>? = null
    var right: TreeNode<T>? = null
}

fun createSampleTree(): TreeNode<Int> {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    root.right!!.left = TreeNode(6)
    root.right!!.right = TreeNode(7)

    return root
}