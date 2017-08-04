package www.breadboy.com.ctci.question3_sort_stack.util

import java.util.*

/**
 * Created by N4039 on 2017-08-03.
 */

class BinarySearcher<T>(val linkedList: LinkedList<T>, val value: T) {

    var start = 0
    var mid = -1
    var end = linkedList.size

    private fun binarySearch(): Int {
        try {
            while (start < end) {
                mid = start + (end - start) / 2

                searchAsString()
            }

            return end
        } catch (e: Exception) {
            return -1
        }
    }

    private fun searchAsInt() {
        val listValueAsInt = linkedList.get(mid) as Int
        val compareValueAsInt = value as Int

        if (listValueAsInt < compareValueAsInt) {
            start = mid + 1
        } else if (listValueAsInt > compareValueAsInt) {
            end = mid
        } else throw Exception()
    }

    private fun searchAsString() {
        val compareResult = linkedList.get(mid).toString().compareTo(value.toString())

        if (compareResult < 0) {
            start = mid + 1
        } else if (compareResult > 0) {
            end = mid
        } else throw Exception()
    }

    fun getInsertedIndex() = binarySearch()
}