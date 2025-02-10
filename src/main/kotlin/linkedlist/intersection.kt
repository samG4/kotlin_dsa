package linkedlist

fun main() {
    // ✅ Test Case 1: Intersection at Node(8)
    val common = Node(8).apply {
        next = Node(10)
    }

    val headA = Node(3).apply {
        next = Node(7).apply {
            next = common
        }
    }

    val headB = Node(99).apply {
        next = Node(1).apply {
            next = common
        }
    }

    println("Expected Intersection: 8, Found: ${findIntersection(headA, headB)?.data}")


    // ✅ Test Case 2: No Intersection
    val list1 = Node(1).apply {
        next = Node(2).apply {
            next = Node(3)
        }
    }

    val list2 = Node(4).apply {
        next = Node(5)
    }

    println("Expected Intersection: null, Found: ${findIntersection(list1, list2)?.data}")


    // ✅ Test Case 3: Intersection at Head (Entire list is common)
    val commonHead = Node(1).apply {
        next = Node(2).apply {
            next = Node(3)
        }
    }

    val headC = commonHead
    val headD = commonHead

    println("Expected Intersection: 1, Found: ${findIntersection(headC, headD)?.data}")


    // ✅ Test Case 4: Intersection at Last Node
    val lastNode = Node(9)

    val headE = Node(4).apply {
        next = Node(5).apply {
            next = lastNode
        }
    }

    val headF = Node(6).apply {
        next = Node(7).apply {
            next = lastNode
        }
    }

    println("Expected Intersection: 9, Found: ${findIntersection(headE, headF)?.data}")
}


fun findIntersection(list1: Node<Int>?, list2: Node<Int>?): Node<Int>? {
    var current1Head = list1
    var current2Head = list2

    val length1 = getLength(list1)
    val lenght2 = getLength(list2)

    val difference = lenght2 - length1
    when {
        difference > 0 -> {
            //l2 is greater than l1
            //chop l2 till diff
            for(i in 0 until difference) {
                current2Head = current2Head?.next
            }
        }
        difference < 0 -> {
            //l1 is greater
            //chop l1 till diff
            for(i in 0 until difference) {
                current1Head = current1Head?.next
            }
        }
        else -> {
            //same length
        }
    }
    while(current1Head != null && current2Head != null) {
        if(current1Head == current2Head) {
            return current1Head
        }
        current1Head = current1Head.next
        current2Head = current2Head.next
    }
    return null
}