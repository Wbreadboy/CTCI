package www.breadboy.com.ctci.data

/**
 * Created by N4039 on 2017-07-24.
 */
class Node<T>(value: T) {
    var value: T = value

    var next: Node<T>? = null
    var previous: Node<T>? = null
}