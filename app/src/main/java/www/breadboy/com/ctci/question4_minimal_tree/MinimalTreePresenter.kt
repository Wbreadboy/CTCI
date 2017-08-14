package www.breadboy.com.ctci.question4_minimal_tree

import www.breadboy.com.ctci.question4_minimal_tree.tree.MinimalTree
import www.breadboy.com.ctci.question4_minimal_tree.util.ArrayUtil
import javax.inject.Inject

/**
 * Created by N4039 on 2017-08-14.
 */
class MinimalTreePresenter

@Inject
constructor(val minimalTreeActivity: MinimalTreeActivity) : MinimalTreeContract.Presenter {

    lateinit var minimalTree: MinimalTree<Int>
    val arrayUtil = ArrayUtil()

    override fun start() {
        initMinimalTree()
    }

    override fun initMinimalTree() {
        minimalTree = MinimalTree()
    }

    override fun stringToIntArray(values: String): IntArray {
        return arrayUtil.stringToIntArray(values)
    }

    override fun clickInputBtn() {
        minimalTreeActivity.printMinimalTree()
    }

    override fun initTreeData() {
        minimalTreeActivity.initTreeData()
    }
}