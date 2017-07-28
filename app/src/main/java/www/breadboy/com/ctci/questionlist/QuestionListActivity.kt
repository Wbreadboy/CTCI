package www.breadboy.com.ctci.questionlist

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import www.breadboy.com.ctci.R
import www.breadboy.com.ctci.application.CtciApplication
import javax.inject.Inject

class QuestionListActivity : QuestionListContract.View() {

    @Inject
    lateinit var qustionListActivity: QuestionListActivity

    @Inject
    lateinit var questionListPresenter: QuestionListContract.Presenter

    @Inject
    lateinit var questionListAdapter: QuestionListAdapter

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setupActivityComponent()
        setRecyclerView()
    }

    override fun onResume() {
        super.onResume()

        questionListPresenter.start()
    }

    override fun setupActivityComponent() {
        (CtciApplication[this].getQuestionComponentBuilder(QuestionListActivity::class.java) as QuestionListComponent.Builder)
                .questionMoudule(QuestionListModule(this))
                .build()
                .injectMembers(this)
    }

    private fun setRecyclerView() {
        activity_main_recyclerview.setLayoutManager(linearLayoutManager)
        activity_main_recyclerview.setAdapter(questionListAdapter)
    }

    override fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
