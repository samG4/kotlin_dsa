package linkedlist


fun main() {
    val head = Node(1)
    head.next = Node(2)
    head.next!!.next = Node(3)
    head.next!!.next!!.next = Node(4)
    head.next!!.next!!.next!!.next = Node(5)
    head.next!!.next!!.next!!.next!!.next = Node(3)
    head.next!!.next!!.next!!.next!!.next!!.next = Node(4)

    printList(head)
    val node = returnKth(head, 6)

    print(node?.data ?: "NA")
}

fun returnKth(head: Node<Int>?, kthIndex: Int): Node<Int>? {
    var kForwardNode = head;
    var currentNode = head;
    var i = 0

    while (i < kthIndex && kForwardNode != null) {
        kForwardNode = kForwardNode.next
        i++
    }
    if (kForwardNode == null && i < kthIndex) {
        //there are less nodes available then index which is asked
        return null
    }

    if (kForwardNode == null) {
        return currentNode
    }

    while (kForwardNode != null) {
        currentNode = currentNode?.next
        kForwardNode = kForwardNode.next
    }

    return currentNode
}