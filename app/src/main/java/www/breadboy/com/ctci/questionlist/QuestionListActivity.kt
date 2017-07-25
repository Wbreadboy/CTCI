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
        (CtciApplication[this].getQuestionListComponentBuilder(QuestionListActivity::class.java) as QuestionListComponent.Builder)
                .questionListMoudule(QuestionListModule(this))
                .build()
                .injectMembers(this)
    }

    private fun setRecyclerView() {
        activity_main_recyclerview.setLayoutManager(linearLayoutManager)
        activity_main_recyclerview.setAdapter(questionListAdapter)
    }
}
