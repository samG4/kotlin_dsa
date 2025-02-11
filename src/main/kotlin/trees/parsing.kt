package trees

fun main() {
    var node = createSampleTree()
    inOrderTraversing(node, 0);
}

fun inOrderTraversing(root: TreeNode<Int>?, level: Int) {
    if (root?.left != null)
        inOrderTraversing(root.left, level + 1)
    println(" ".repeat(level * 4) + root?.value + "  ")
    if (root?.right != null)
        inOrderTraversing(root.right, level + 1)
}

fun preOrderTraversing(root: TreeNode<Int>?, level: Int) {
    println(" ".repeat(level * 4) + root?.value + "  ")
    if (root?.left != null)
        preOrderTraversing(root.left, level + 1)
    if (root?.right != null)
        preOrderTraversing(root.right, level + 1)
}

fun postOrderTraversing(root: TreeNode<Int>?, level: Int) {
    if (root?.left != null)
        postOrderTraversing(root.left, level + 1)
    if (root?.right != null)
        postOrderTraversing(root.right, level + 1)
    println(" ".repeat(level * 4) + root?.value + "  ")
}