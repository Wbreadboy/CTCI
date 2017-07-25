package www.breadboy.com.ctci.question2_runner

import android.text.TextUtils

/**
 * Created by N4039 on 2017-07-24.
 *
 * Runner technique LinkedList
 */

class LinkedList<T> {

    private var head: Node<T>? = null

    private var follower: Node<T>? = null
    private var runner: Node<T>? = null

    /**
     * LinkedList의 마지막 node를 반환
     *
     * @return  마지막 노드
     */
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

    /**
     * EditText view에서 입력된 값을 LinkedList로 변환
     *
     * @param linkedList    EditText getText
     */
    fun appendToEditText(linkedList: String) {
        val nodeArray: Array<String> = TextUtils.split(linkedList, "\\s+")

        for (node in nodeArray) {
            appendToTail(node as T)
        }
    }

    /**
     * LinkedList의 제일 마지막에 node 삽입
     *
     * @param value value
     */
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

    /**
     * 해당 node 다음에 새로운 node 삽입
     *
     * @param targetNode    target node
     * @param value         inserting node value
     */
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

    /**
     * 해당 노드를 삭제
     *
     * @param node      deleting node
     */
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

    /**
     * 모든 노드 삭제
     */
    fun removeAll() {
        head = null
    }

    /**
     * Runner technique
     *
     * @param followCount   뒤따라가는 pointer의 이동 거리
     * @param runCount      앞서가는 pointer의 이동 거리
     */
    fun runnerTechnique(followCount: Int, runCount: Int) {
        follower = head
        runner = runToLinkedList(head, runCount - 1)

        while (runner?.next != null) {
            follower = runToLinkedList(follower, followCount)
            runner = runToLinkedList(runner, runCount)
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

    /**
     * 해당 node를 입력한 거리만큼 이동
     *
     * @param count 이동시킬 거리
     * @param node  이동시킬 node
     * @return      이동시킨 node 반환
     */
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

    /**
     * 모든 node printing
     *
     * @return All node
     */
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