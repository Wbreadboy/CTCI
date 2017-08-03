package www.breadboy.com.ctci.question3_sort_stack.stack

import java.util.*

/**
 * Created by N4039 on 2017-08-03.
 */

class SortStack<T> {
    var ascLinkedList = LinkedList<T>()

    fun push(value: T) {
        ascLinkedList.addLast(value)
    }

    fun pop() = ascLinkedList.removeLast()

    fun peek() = ascLinkedList.peekLast()

    fun isEmpty() = ascLinkedList.isEmpty()
}