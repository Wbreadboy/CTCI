package www.breadboy.com.ctci.question4_minimal_tree.tree.tree

/**
 * Created by N4039 on 2017-08-14.
 */
class MinimalTree {

    fun arrayToBST(array: IntArray, start: Int, end: Int): Node<Int>? {
        if (end < start) return null

        val mid = (start + end) / 2

        val root = Node<Int>(array[mid])
        root.left = arrayToBST(array, 0, mid - 1)
        root.right = arrayToBST(array, mid + 1, end)

        return root
    }
}