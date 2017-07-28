package www.breadboy.com.ctci.question3_animal_shelter.Queue

/**
 * Created by SDG on 2017. 7. 28..
 */
class Queue<T> {
    var rear: Node<T>? = null
    var front: Node<T>? = null

    fun enQueue(item: T) {
        if (front == null) {
            rear = Node(item)
            front = rear
        } else {
            rear?.next = Node(item)
            rear = rear?.next
        }
    }

    fun deQueue(): T {

    }

    fun isEmpty(): Boolean {
        return front == null
    }

    fun isFull(): Boolean {

    }

}