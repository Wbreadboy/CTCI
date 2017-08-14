package www.breadboy.com.ctci.question3_sort_stack.stack

import www.breadboy.com.ctci.question3_sort_stack.util.BinarySearcher
import java.util.*

/**
 * Created by N4039 on 2017-08-03.
 */

class SortStack<T> {
    var ascLinkedList = LinkedList<T>()

    fun push(value: T) {
        val insertedIndex = BinarySearcher(ascLinkedList, value).getInsertedIndex()

        if (insertedIndex != -1) ascLinkedList.add(insertedIndex, value) else return
    }

    fun pop() = ascLinkedList.removeLast()

    fun peek() = ascLinkedList.peekLast()

    fun isEmpty() = ascLinkedList.isEmpty()

    override fun toString(): String {
        val linkedListSb = StringBuilder()
        var count = 0

        for (value in ascLinkedList) {
            linkedListSb.append(value)
            linkedListSb.append(if (++count != ascLinkedList.size) " -> " else "(top)")
        }

        return linkedListSb.toString()
    }
}