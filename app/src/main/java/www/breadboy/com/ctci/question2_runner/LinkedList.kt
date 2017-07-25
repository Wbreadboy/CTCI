package www.breadboy.com.ctci.question2_runner

/**
 * Created by N4039 on 2017-07-24.
 */

class LinkedList<T> {

    private var head: Node<T>? = null

    private var follower: Node<T>? = null
    private var runner: Node<T>? = null

    fun findLastNode(): Node<T>? {
        var node = head

        if (node == null) {
            return null
        }

        while (node?.next != null) {
            node = node.next
        }

        return node
    }

    fun appendToTail(value: T) {
        val newNode = Node(value)
        val lastNode = this.findLastNode()

        if (lastNode != null) {
            newNode.previous = lastNode
            lastNode.next = newNode
        } else {
            head = newNode
        }
    }

    fun appendToNode(targetNode: Node<T>?, value: T) {
        val newNode = Node(value)
        val nextNode = targetNode?.next

        if (targetNode != null) {
            newNode.previous = targetNode
            targetNode.next = newNode
            newNode.previous = targetNode
        } else {
            head = newNode
        }

        newNode.next = nextNode
    }

    fun removeNode(node: Node<T>): T {
        val prevNode = node.previous
        val nextNode = node.next

        if (prevNode != null) {
            prevNode.next = nextNode
        } else {
            head = nextNode
        }

        nextNode?.previous = prevNode

        node.previous = null
        node.next = null

        return node.value
    }

    fun runnerTechnique(followCount: Int, runCount: Int) {
        follower = head
        runner = runToLinkedList(head, runCount - 1)

        while (runner?.next != null) {
            follower = runToLinkedList(follower, followCount)
            runner = runToLinkedList(runner, runCount)
        }

        runner = runToLinkedList(head, runCount - 1)

        while (follower?.next != null) {
            appendToNode(runner, follower!!.value)
            follower = runToLinkedList(follower, followCount)
        }
    }

    fun runToLinkedList(node: Node<T>?, count: Int): Node<T>? {
        var runNode: Node<T>? = null

        for (i in 0..count) {
            if (node?.next == null) {
                return null
            }

            runNode = node.next
        }

        return runNode
    }
}