package linkedlist

//fun main() {
//    val head = Node(1)
//    val node2 = Node(2)
//    val node3 = Node(3)
//    val node4 = Node(4)
//    val node5 = Node(5)
//    val node6 = Node(6)
//    head.next = node2
//    head.next!!.next = node3
//    head.next!!.next!!.next = node4
//    head.next!!.next!!.next!!.next = node5
//    head.next!!.next!!.next!!.next!!.next = node6
//    head.next!!.next!!.next!!.next!!.next!!.next = Node(4)
//
//    printList(head)
//    deleteMiddleNode(node4)
//    printList(head)
//}

fun deleteMiddleNode(node: Node<Int>?) {
    if(node == null) {
        return
    }
    val newNode = node.next
        ?: //cant handle
        return

    newNode.data = node.next?.data!!
    node.data = newNode.data
    node.next = newNode.next

}