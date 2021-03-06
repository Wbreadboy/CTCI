package www.breadboy.com.ctci.question2_runner

import www.breadboy.com.ctci.base.BaseActivity
import www.breadboy.com.ctci.base.BasePresenter

/**
 * Created by N4039 on 2017-07-25.
 */
interface RunnerTechniqueContract {
    abstract class View : BaseActivity<Presenter>()

    interface Presenter : BasePresenter {

        fun initLinkedList()

        fun inputNodeToEditText()

        fun runSearchLinkedList()

        fun printRunnerTechLinkedList()

        fun clickInputBtn()
    }
}