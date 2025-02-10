package linkedlist

data class Node<T>(var data: T, var next: Node<T>? = null)


data class DoublyNode<T>(var data: T, var prev: DoublyNode<T>? = null, var next: DoublyNode<T>? = null)


fun printList(head: Node<Int>?) {
    var current = head
    while (current != null) {
        print("${current.data} -> ")
        current = current.next
    }
    println("null")
}