package www.breadboy.com.ctci.question4_minimal_tree.tree

/**
 * Created by N4039 on 2017-08-14.
 */
class Node<T>(var data: T) {
    var left: Node<T>? = null
    var right: Node<T>? = null
}