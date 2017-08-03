package www.breadboy.com.ctci.question3_sort_stack.util

import java.util.*

/**
 * Created by N4039 on 2017-08-03.
 */
class BinarySearcher<T>(val linkedList: LinkedList<T>, val value: T) {

    var start = 0
    var mid: Int
    var end = linkedList.size

    private fun binarySearch(): Int {

        while (start < end) {
            mid = start + (end - start) / 2

            if (value is Int) searchAsInt() else searchAsString()


        }

        return end
    }

    private fun searchAsInt() {
        val listValueAsInt = linkedList.get(mid) as Int
        val compareValueAsInt = value as Int

        if (listValueAsInt < compareValueAsInt) {
            start = mid + 1
        } else if (listValueAsInt > compareValueAsInt) {
            end = mid
        } else return
    }

    private fun searchAsString() {
        val compareResult = linkedList.get(mid).toString().compareTo(value.toString())

        if (compareResult < 0) {
            start = mid + 1
        } else if (compareResult > 0) {
            end = mid
        } else {
            return
        }
    }

    fun getInsertedIndex() = if (value is Int) binarySearchAsInt() else binarySearchAsString()
}