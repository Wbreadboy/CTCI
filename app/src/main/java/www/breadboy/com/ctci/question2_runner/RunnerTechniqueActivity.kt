package www.breadboy.com.ctci.question2_runner

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_runner_technique.*
import www.breadboy.com.ctci.R
import www.breadboy.com.ctci.application.CtciApplication
import www.breadboy.com.ctci.questionlist.QuestionListActivity
import www.breadboy.com.ctci.questionlist.QuestionListComponent
import www.breadboy.com.ctci.questionlist.QuestionListModule
import javax.inject.Inject

class RunnerTechniqueActivity : RunnerTechniqueContract.View(), View.OnClickListener {

    @Inject
    lateinit var runnerTechniqueActivity: RunnerTechniqueActivity

    @Inject
    lateinit var runnerTechniquePresenter: RunnerTechniqueContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_runner_technique)
        setupActivityComponent()
        initView()
    }

    override fun onResume() {
        super.onResume()

        runnerTechniquePresenter.start()
    }

    fun initView() {
        btn_activity_runner.setOnClickListener(this)
    }

    override fun setupActivityComponent() {
        (CtciApplication[this].getQuestionComponentBuilder(RunnerTechniqueActivity::class.java) as RunnerTechniqueComponent.Builder)
                .questionMoudule(RunnerTechniqueModule(this))
                .build()
                .injectMembers(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            btn_activity_runner -> runnerTechniquePresenter.clickInputBtn()
        }
    }
}
