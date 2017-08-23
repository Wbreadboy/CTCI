package www.breadboy.com.ctci.question4_check_balance_tree

import www.breadboy.com.ctci.data.TreeNode

/**
 * Created by N4039 on 2017-08-23.
 */

class Tree<T> {

    var root: TreeNode<T>? = null

    fun arrayToTree(array: Array<T>): TreeNode<T>? {
        for (data: T in array) {
            insert(data)
        }

        return root
    }

    fun insert(data: T): TreeNode<T> {
        if (root == null) root = TreeNode(data)
        else {
            if ((root!!.data as Int) > (data as Int)) {
                insert(root!!.left!!.data)
            } else if ((root!!.data as Int) < (data as Int)) {
                insert(root!!.right!!.data)
            }
        }

        return root as TreeNode<T>
    }

    fun delete(node: TreeNode<T>?): TreeNode<T>? {
        var root = node
        val delNode = find(root, root!!.data)

        if (delNode!!.left != null && delNode.right != null) {
            delNode.data = findMax(delNode.left)!!.data
            root.left = delete(root.left)
        } else {
            if (root.left == null) root = root.right
            if (root!!.right == null) root = root.left
        }

        return root
    }

    fun find(node: TreeNode<T>?, data: T): TreeNode<T>? {
        if (root == null) return null
        else {
            if ((root!!.data as Int) > (data as Int)) {
                find(root!!.left, data)
            } else if ((root!!.data as Int) < (data as Int)) {
                find(root!!.right, data)
            } else {
                return root
            }
        }

        return null
    }

    fun findMax(root: TreeNode<T>?): TreeNode<T>? {
        return if (root!!.right == null) root else findMax(root.right!!)
    }

    fun findMin(root: TreeNode<T>): TreeNode<T>? {
        return if (root.left == null) root else findMin(root.left!!)
    }
}