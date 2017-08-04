package www.breadboy.com.ctci.question3_sort_stack

import www.breadboy.com.ctci.base.BaseActivity
import www.breadboy.com.ctci.base.BasePresenter

/**
 * Created by N4039 on 2017-08-04.
 */
interface SortStackContract {

    abstract class View : BaseActivity<Presenter>()

    interface Presenter : BasePresenter {

        fun initSortStack()

        fun pushSortStack()

        fun printSortStack()

        fun clearEditText()

        fun clickInputBtn()
    }
}