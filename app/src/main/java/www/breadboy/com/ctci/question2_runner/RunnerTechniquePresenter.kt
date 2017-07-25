package www.breadboy.com.ctci.question2_runner

import kotlinx.android.synthetic.main.activity_runner_technique.*
import www.breadboy.com.ctci.question2_runner.linkedlist.LinkedList
import javax.inject.Inject

/**
 * Created by SDG on 2017. 7. 26..
 */
class RunnerTechniquePresenter

@Inject
constructor(val runnerTechniqueActivity: RunnerTechniqueActivity) : RunnerTechniqueContract.Presenter {

    lateinit var linkedList: LinkedList<String>

    override fun start() {
        initLinkedList()
    }

    override fun initLinkedList() {
        linkedList = LinkedList()
    }

    override fun inputNodeToEditText() {
        linkedList.removeAll()
        linkedList.appendToEditText(runnerTechniqueActivity.edittext_activity_runner.text.toString())
    }

    override fun runSearchLinkedList() {
        linkedList.runnerTechnique(1, 2)
    }

    override fun printRunnerTechLinkedList() {
        runnerTechniqueActivity.textview_activity_runner.setText(linkedList.toString())
    }

    override fun clickInputBtn() {
        inputNodeToEditText()
        runSearchLinkedList()
        printRunnerTechLinkedList()
    }
}