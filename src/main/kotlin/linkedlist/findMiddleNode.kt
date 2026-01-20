package linkedlist

//fun main() {
//    val head = Node(1)
//    head.next = Node(2)
//    head.next!!.next = Node(3)
//    head.next!!.next!!.next = Node(4)
//    head.next!!.next!!.next!!.next = Node(5)
//    head.next!!.next!!.next!!.next!!.next = Node(3)
////    head.next!!.next!!.next!!.next!!.next!!.next = Node(4)
//
//    printList(head)
//    val node = findMiddleNode(head)
//    println(node?.data ?: "NA")
//}

fun findMiddleNode(head: Node<Int>?) : Node<Int>? {
    var slowP = head
    var fastP = head

    while(fastP?.next != null) {
        slowP = slowP?.next
        fastP = fastP?.next?.next
    }
    return slowP
}