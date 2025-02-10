package linkedlist


fun main() {
    val head = Node(1)
    head.next = Node(1)
    head.next!!.next = Node(1)
    head.next!!.next!!.next = Node(2)
    head.next!!.next!!.next!!.next = Node(3)
    head.next!!.next!!.next!!.next!!.next = Node(3)
    head.next!!.next!!.next!!.next!!.next!!.next = Node(4)

    printList(head)
    removeDuplicates(head)
    printList(head)
}

fun removeDuplicatesWithBuffer(head: Node<Int>?) {
    val set = mutableSetOf<Int>()

    var currentHead = head
    var previous: Node<Int>? = null
    while (currentHead != null) {
        val data: Int = currentHead.data
        if (set.contains(data)) {
            previous?.next = currentHead.next
        } else {
            set.add(data)
            previous = currentHead
        }
        currentHead = currentHead.next
    }
}

fun removeDuplicates(head: Node<Int>?) {
    var currentHead = head
    var runner: Node<Int>?
    while(currentHead != null) {
        runner = currentHead
        while(runner?.next != null) {
            if(runner.next?.data == currentHead.data) {
                runner.next = runner.next?.next
            } else {
                runner = runner.next
            }
        }
        currentHead = currentHead.next
    }
}


