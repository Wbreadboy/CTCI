package www.breadboy.com.ctci.question2_runner

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_runner_technique.*
import www.breadboy.com.ctci.R

class RunnerTechniqueActivity : RunnerTechniqueContract.View(), View.OnClickListener {
    lateinit var linkedList: LinkedList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runner_technique)

        initLinkedList()
        initView()
    }

    fun initLinkedList() {
        linkedList = LinkedList()
    }

    fun initView() {
        btn_activity_runner.setOnClickListener(this)
    }

    fun inputNodeToLinkedList() {
        linkedList.removeAll()
        linkedList.appendToEditText(edittext_activity_runner.text.toString())

        printRunnerTeqhLinkedList()

        runSearchLinkedList()
    }

    fun runSearchLinkedList() {
        linkedList.runnerTechnique(1, 2)

        printRunnerTeqhLinkedList()
    }

    fun printRunnerTeqhLinkedList() {
        textview_activity_runner.setText(linkedList.toString())
    }

    override fun setupActivityComponent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClick(view: View?) {
        when (view) {
            btn_activity_runner -> inputNodeToLinkedList()
        }
    }
}
