package linkedlist

fun main() {
    val head = Node(1)
    head.next = Node(2)
    head.next!!.next = Node(3)
//    head.next!!.next!!.next = Node(3)
    head.next!!.next!!.next = Node(2)
    head.next!!.next!!.next!!.next = Node(1)

    printList(head)
    isPalindrome(head)
}

fun isPalindrome(head: Node<Int>?): Boolean {
    val length = getLength(head)
    var slow = head
    var fast = head
    val dataInPart1 = mutableListOf<Int>()
    while (fast != null) {
        fast = fast.next?.next
        dataInPart1.add(slow!!.data)
        slow = slow.next
    }
    if(length % 2 != 0 ) {
        dataInPart1.removeLast()
    }
    println(dataInPart1)
    printList(slow)

    while (slow != null) {
        var storedData: Int? = null
        if (dataInPart1.isNotEmpty()) {
            storedData = dataInPart1.removeLast()
        } else {
            return false
        }
        println(storedData.toString() + " -> " + slow.data)
        if (storedData != slow.data)
            return false
        slow = slow.next
    }
    return true
}