package linkedlist

fun main() {
    // ✅ Test Case 1: Loop Exists (Cycle at Node(3))
    val headA = Node(1).apply {
        next = Node(2).apply {
            next = Node(3).apply {
                next = Node(4).apply {
                    next = this // Creating a cycle (loop at Node 3)
                }
            }
        }
    }
    val node = findLoop(headA)
    println("Expected: true, Found: ${node?.data}")
}


fun findLoop(head: Node<Int>?): Node<Int>? {
    var slowRunner = head
    var fastRunner = head

    while (fastRunner?.next != null) {
        println(fastRunner?.data)
        println(slowRunner?.data)
        fastRunner = fastRunner.next?.next
        slowRunner = slowRunner?.next
        if (slowRunner == fastRunner)
            break
    }
    if (fastRunner?.next == null)
        return null

    slowRunner = head
    while (fastRunner != slowRunner) {
        println("in second loop");
        slowRunner = slowRunner?.next
        fastRunner = fastRunner?.next
    }
    println("outside second loop");
    return fastRunner
}