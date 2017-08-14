package www.breadboy.com.ctci.question4_minimal_tree

import www.breadboy.com.ctci.base.BaseActivity
import www.breadboy.com.ctci.base.BasePresenter

/**
 * Created by N4039 on 2017-08-14.
 */
interface MinimalTreeContract {

    abstract class View : BaseActivity<Presenter>() {

    }

    interface Presenter : BasePresenter {

        fun initMinimalTree()

        fun stringToIntArray(values: String): IntArray

        fun clickInputBtn()

        fun initTreeData()
    }
}