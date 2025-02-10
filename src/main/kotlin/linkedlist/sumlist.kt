package linkedlist

import java.lang.Math.abs


fun main() {
    val head = Node(9)
    head.next = Node(9)
    head.next!!.next = Node(9)
//    head.next!!.next = Node(3)
//    head.next!!.next!!.next = Node(4)
//    head.next!!.next!!.next!!.next = Node(5)
//    head.next!!.next!!.next!!.next!!.next = Node(3)
//    head.next!!.next!!.next!!.next!!.next!!.next = Node(4)

    val secondHead = Node(2)

    printList(head)
    sumListForward(head, secondHead)
//    printList(result)

}

fun sumListReverse(list1: Node<Int>?, list2: Node<Int>?, carry: Int): Node<Int>? {
    if (list1 == null && list2 == null && carry == 0)
        return null
    val sum = carry + (list1?.data ?: 0) + (list2?.data ?: 0)
    val onesDigit = sum % 10
    val newCarry = sum / 10;
    val result = Node(onesDigit)

    if (list1 != null || list2 != null) {
        val nextResult = sumListReverse(list1?.next, list2?.next, newCarry)
        result.next = nextResult
    }

    return result

}

fun sumListForward(list1: Node<Int>?, list2: Node<Int>?) {
    //get length of list
    val list1Length = getLength(list1)
    val list2Length = getLength(list2)
    var newList1Head = list1
    var newList2Head = list2

    //add 0 to shorterList
    val difference = abs((list1Length - list2Length))
    when {
        list1Length < list2Length -> {
            newList1Head = padZero(list1, difference)
        }
        list1Length > list2Length -> {
            newList2Head = padZero(list2, difference)
        }
        else -> {
                //dont do anything
        }
    }

    val (sumHead, carry) = performAddition(newList1Head, newList2Head)
    println("finished recursion")
    val finalResult = if(carry > 0) {
        Node(carry)?.apply { next = sumHead }
    } else {
        sumHead
    }
    printList(finalResult)

}

fun performAddition(head1: Node<Int>?, head2: Node<Int>?): Pair<Node<Int>?, Int> {
    if(head1 == null && head2 == null) return Pair(null, 0)
    println("for: ${head1?.next?.data}, ${head2?.next?.data}")
    val (result, interimCarry) = performAddition(head1?.next, head2?.next)
    println("interimCarry: ${interimCarry}, result: ${result?.data}")
    val sum = interimCarry + (head1?.data ?: 0) + (head2?.data ?: 0)
    val value = sum%10
    val carry = sum/10
    val newNode = Node(value)
    newNode.next = result
    return Pair(newNode, carry)
}

fun getLength(head: Node<Int>?) : Int {
    var length = 0;
    var current = head
    while(current!= null) {
        length++
        current = current.next
    }
    return length;
}


fun padZero(head: Node<Int>?, addLZero: Int): Node<Int>? {
    var newHead = head
    for(i in 0 until addLZero) {
        val newNode = Node(0)
        newNode.next = newHead
        newHead = newNode
    }
    printList(newHead)
    return newHead
}

/*fun sumListForward(list1: Node<Int>?, list2: Node<Int>?): Node<Int>? {
    val len1 = getLength(list1)
    val len2 = getLength(list2)

    // Pad the shorter list with leading zeros
    val (paddedList1, paddedList2) = if (len1 > len2) {
        list1 to padZeros(list2, len1 - len2)
    } else {
        padZeros(list1, len2 - len1) to list2
    }

    // Perform recursive summation
    val (sumHead, carry) = addLists(paddedList1, paddedList2)

    // If there's a carry left, prepend a new node
    return if (carry > 0) Node(carry).apply { next = sumHead } else sumHead
}

// Recursively adds corresponding nodes and returns the sum head and carry
private fun addLists(l1: Node<Int>?, l2: Node<Int>?): Pair<Node<Int>?, Int> {
    if (l1 == null && l2 == null) return null to 0

    val (nextSum, carry) = addLists(l1?.next, l2?.next)
    val sum = carry + (l1?.data ?: 0) + (l2?.data ?: 0)
    val newNode = Node(sum % 10).apply { next = nextSum }

    return newNode to (sum / 10)
}

// Returns length of the linked list
private fun getLength(node: Node<Int>?): Int {
    var count = 0
    var current = node
    while (current != null) {
        count++
        current = current.next
    }
    return count
}

// Pads a linked list with leading zeros
private fun padZeros(node: Node<Int>?, count: Int): Node<Int>? {
    var head = node
    repeat(count) {
        head = Node(0).apply { next = head }
    }
    return head
}*/
