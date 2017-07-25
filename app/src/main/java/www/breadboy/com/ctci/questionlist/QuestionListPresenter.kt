package www.breadboy.com.ctci.questionlist

import www.breadboy.com.ctci.ActivityScope
import www.breadboy.com.ctci.data.Question
import javax.inject.Inject

/**
 * Created by SDG on 2017. 7. 12..
 */

@ActivityScope
class QuestionListPresenter

@Inject
constructor(val questionListActivity: QuestionListActivity) : QuestionListContract.Presenter {

    override fun start() {
        questionListActivity.questionListAdapter.addQuestion(Question(QuestionListActivity(), "2-runner"))
    }
}