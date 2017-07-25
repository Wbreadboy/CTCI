package www.breadboy.com.ctci.questionlist

import android.support.v7.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides
import www.breadboy.com.ctci.base.BaseModule

/**
 * Created by SDG on 2017. 7. 12..
 */

@Module
class QuestionListModule(var questionListActivity: QuestionListActivity) : BaseModule<QuestionListActivity>(questionListActivity) {

    @ActivityScope
    @Provides
    fun provideQuestionListActivity(): QuestionListActivity {
        return questionListActivity
    }

    @ActivityScope
    @Provides
    fun provideQuestionListPresenter(questionListActivity: QuestionListActivity): QuestionListContract.Presenter {
        return QuestionListPresenter(questionListActivity)
    }

    @ActivityScope
    @Provides
    fun provideQuestionListAdapter(questionListActivity: QuestionListActivity, questionListPresenter: QuestionListPresenter): QuestionListAdapter {
        return QuestionListAdapter(questionListActivity, questionListPresenter)
    }

    @ActivityScope
    @Provides
    fun provideLinearLayoutManager(questionListActivity: QuestionListActivity): LinearLayoutManager {
        return LinearLayoutManager(questionListActivity)
    }
}