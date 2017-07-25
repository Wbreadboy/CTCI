package www.breadboy.com.ctci.questionlist

import www.breadboy.com.ctci.data.Question
import www.breadboy.com.ctci.question2_runner.RunnerTechniqueActivity
import javax.inject.Inject

/**
 * Created by SDG on 2017. 7. 12..
 */

@ActivityScope
class QuestionListPresenter

@Inject
constructor(val questionListActivity: QuestionListActivity) : QuestionListContract.Presenter {

    override fun start() {
        questionListActivity.questionListAdapter.addQuestion(Question(RunnerTechniqueActivity(), "2-runner"))
    }
}