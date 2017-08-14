package www.breadboy.com.ctci.question4_minimal_tree.util

import android.util.Log

/**
 * Created by N4039 on 2017-08-14.
 */

class ArrayUtil {

    fun stringToIntArray(values: String): IntArray {
        val strArray = values.split(" ")
        val intArray = kotlin.IntArray(strArray.size)

        for (arrIndex in 0 until strArray.size) {
            intArray[arrIndex] = strArray[arrIndex].toInt()
        }

        return intArray
    }
}