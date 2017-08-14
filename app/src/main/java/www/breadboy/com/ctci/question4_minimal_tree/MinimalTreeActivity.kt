package www.breadboy.com.ctci.question4_minimal_tree

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_minimal_tree.*
import www.breadboy.com.ctci.R
import www.breadboy.com.ctci.application.CtciApplication
import javax.inject.Inject

class MinimalTreeActivity : MinimalTreeContract.View(), View.OnClickListener {

    @Inject
    lateinit var minimalTreePresenter: MinimalTreePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_minimal_tree)
        setupActivityComponent()

        initView()
    }

    override fun onResume() {
        super.onResume()

        minimalTreePresenter.start()
    }

    override fun setupActivityComponent() {
        (CtciApplication[this].getQuestionComponentBuilder(MinimalTreeActivity::class.java) as MinimalTreeComponent.Builder)
                .questionMoudule(MinimalTreeModule(this))
                .build()
                .injectMembers(this)
    }

    private fun initView() {
        btn_activity_minimal_tree.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            btn_activity_minimal_tree -> minimalTreePresenter.clickInputBtn()
        }
    }

    fun printMinimalTree() {
        val intArray = minimalTreePresenter.stringToIntArray(edittext_activity_minimal_tree.text.toString())

        minimalTreePresenter.initTreeData()

        textview_activity_minimal_tree.text =
                minimalTreePresenter.minimalTree.inOrderTrav(minimalTreePresenter.minimalTree.arrayToBST(intArray, 0, intArray.size - 1))
    }

    fun initTreeData() {
        edittext_activity_minimal_tree.text.clear()
        minimalTreePresenter.minimalTree.initTreeStringBuilder()
    }
}
