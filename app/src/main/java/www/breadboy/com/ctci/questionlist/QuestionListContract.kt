package www.breadboy.com.ctci.questionlist

import android.content.Context
import www.breadboy.com.ctci.base.BaseActivity
import www.breadboy.com.ctci.base.BasePresenter

/**
 * Created by SDG on 2017. 7. 12..
 */

interface QuestionListContract {
    abstract class View : BaseActivity<Presenter>()

    interface Presenter : BasePresenter {

        fun onQuestionClick(context: Context, questionActivity: BaseActivity<*>) {
            questionActivity.startWithQuestion(context, questionActivity)
        }
    }
}