package www.breadboy.com.ctci.question2_runner

import android.text.TextUtils
import android.util.Log
import org.w3c.dom.NodeList

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

    fun appendToEditText(linkedList: String) {
        val nodeArray: Array<String> = TextUtils.split(linkedList, "\\s+")

        for (node in nodeArray) {
            appendToTail(node as T)
        }
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

    fun removeAll() {
        head = null
    }

    fun runnerTechnique(followCount: Int, runCount: Int) {
        follower = head
        runner = runToLinkedList(head, runCount - 1)

        while (runner?.next != null) {
            follower = runToLinkedList(follower, followCount)
            runner = runToLinkedList(runner, runCount)

            Log.e("!!!!!!!!!!!!!!!!!", follower?.value.toString())
            Log.e("!!!!!!!!!!!!!!!!!", runner?.value.toString())
        }

        follower = runToLinkedList(follower, followCount)
        runner = head

        while (follower?.next != null) {
            val nextFollowNode = follower
            follower = runToLinkedList(follower, followCount)

            appendToNode(runner, nextFollowNode!!.value)
            removeNode(nextFollowNode)

            runner = runToLinkedList(runner, runCount)
        }
    }

    fun runToLinkedList(node: Node<T>?, count: Int): Node<T>? {
        var runNode: Node<T>? = node

        for (i in 0 until count) {
            if (runNode?.next == null) {
                return null
            }

            runNode = runNode.next
        }

        return runNode
    }

    override fun toString(): String {
        val linkedListSb: StringBuilder = StringBuilder()
        var node = head

        while (node != null) {
            linkedListSb.append(node.value)

            node = node.next
            if (node != null) {
                linkedListSb.append(" -> ")
            }
        }

        return linkedListSb.toString()
    }
}