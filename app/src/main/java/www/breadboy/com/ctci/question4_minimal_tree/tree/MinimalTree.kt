package www.breadboy.com.ctci.question4_minimal_tree.tree

import android.util.Log

/**
 * Created by N4039 on 2017-08-14.
 */

class MinimalTree<T> {

    var treeStringBuilder = StringBuilder()

    fun arrayToBST(array: IntArray, start: Int, end: Int): Node<Int>? {
        if (end < start) return null

        val mid = (start + end) / 2

        val root = Node<Int>(array[mid])
        root.left = arrayToBST(array, start, mid - 1)
        root.right = arrayToBST(array, mid + 1, end)

        return root
    }

    fun initTreeStringBuilder() {
        treeStringBuilder.setLength(0)
    }

    fun inOrderTrav(root: Node<T>?): String? {
        if (root != null) {
            inOrderTrav(root.left)
            treeStringBuilder.append(root.data)
            treeStringBuilder.append(" -> ")
            inOrderTrav(root.right)
        }

        return treeStringBuilder.toString()
    }
}