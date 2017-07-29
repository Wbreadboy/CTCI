package www.breadboy.com.ctci.question3_animal_shelter.queue

import www.breadboy.com.ctci.question3_animal_shelter.data.Cat
import www.breadboy.com.ctci.question3_animal_shelter.data.Dog

/**
 * Created by SDG on 2017. 7. 28..
 */

class Queue<A> {
    var rear: Node<A>? = null
    var front: Node<A>? = null

    fun add(item: A) {
        val newNode: Node<A> = Node(item)

        if (rear != null) {
            newNode.previous = rear

            rear?.next = newNode
        }

        rear = newNode

        front = if (front == null) rear else front
    }

    fun removeNode(node: Node<A>): Node<A> {
        val prevNode = node.previous
        val nextNode = node.next

        if (prevNode != null) prevNode.next = nextNode else front = nextNode

        nextNode?.previous = prevNode

        rear = if (node == rear) node.previous else rear

        node.previous = null
        node.next = null

        return node
    }

    fun removeAny(): A {
        if (front == null) throw NoSuchElementException()

        val node = front
        val data = front!!.data

        front = front?.next
        front?.previous = null

        node?.previous = null
        node?.next = null

        rear = if (front == null) null else rear

        return data
    }

    fun removeDog(): A? {
        if (front == null) throw NoSuchElementException()

        var nextNode = front
        var data: A

        while (nextNode != null) {
            data = nextNode.data

            if (data is Dog) {
                removeNode(nextNode)

                return data
            } else nextNode = nextNode.next
        }

        throw NoSuchElementException()
    }

    fun removeCat(): A? {
        if (front == null) throw NoSuchElementException()

        var nextNode = front
        var data: A

        while (nextNode != null) {
            data = nextNode.data

            if (data is Cat) {
                removeNode(nextNode)

                return data
            } else nextNode = nextNode.next
        }

        throw NoSuchElementException()
    }

    fun peek(): A {
        if (front == null) throw NoSuchElementException()

        return front!!.data
    }

    fun isEmpty(): Boolean {
        return front == null
    }

    /**
     * 모든 node printing
     *
     * @return All node
     */
    override fun toString(): String {
        val linkedListSb = StringBuilder()
        var node = front

        while (node != null) {
            linkedListSb.append(if (node == front) "(front)" else "")
            linkedListSb.append(node.data)

            node = node.next

            linkedListSb.append(if (node != null) " <-> " else "")
            linkedListSb.append(if (node == rear) "(rear)" else "")
        }

        return linkedListSb.toString()
    }
}