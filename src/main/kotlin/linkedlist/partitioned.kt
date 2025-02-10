package linkedlist

fun main() {
    val head = Node(1)
    head.next = Node(6)
    head.next!!.next = Node(3)
    head.next!!.next!!.next = Node(4)
    head.next!!.next!!.next!!.next = Node(5)
    head.next!!.next!!.next!!.next!!.next = Node(3)
    head.next!!.next!!.next!!.next!!.next!!.next = Node(4)

    printList(head)

    val output = doPartitioned(head, 5)
    printList(output)
}

fun doPartitioned(head: Node<Int>?, partitioned: Int): Node<Int>? {
    var smallerHead: Node<Int>? = null
    var smallerTail: Node<Int>? = null
    var largerHead: Node<Int>? = null
    var largerTail: Node<Int>? = null
    var current = head
    while (current != null) {
        val nextNode = current.next
        current.next = null
        if(current.data < partitioned) {
            if(smallerHead == null) {
                smallerHead = Node(current.data)
                smallerTail = smallerHead
            } else {
                smallerTail?.next = current
                smallerTail = current
            }
        } else {
            if(largerHead == null) {
                largerHead = Node(current.data)
                largerTail = largerHead
            } else {
                largerTail?.next = current
                largerTail = current
            }
        }
        current = nextNode
    }
    if(smallerHead == null) {
        return largerHead
    }

    smallerTail?.next = largerHead
    return smallerHead
}