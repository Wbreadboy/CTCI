package www.breadboy.com.ctci.data

/**
 * Created by N4039 on 2017-07-24.
 */
class LinkedListNode<T>(var value: T) {
    var next: LinkedListNode<T>? = null
    var previous: LinkedListNode<T>? = null
}