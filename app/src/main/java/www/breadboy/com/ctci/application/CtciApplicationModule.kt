package www.breadboy.com.ctci.application

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import www.breadboy.com.ctci.questionlist.QuestionListActivity
import www.breadboy.com.ctci.questionlist.QuestionListComponent
import www.breadboy.com.ctci.questionlist.QuestionListComponentBuilder
import www.breadboy.com.ctci.questionlist.QuestionListKey

/**
 * Created by SDG on 2017. 7. 18..
 */

@Module(subcomponents = arrayOf(QuestionListComponent::class))
abstract class CtciApplicationModule {

    @Binds
    @IntoMap
    @QuestionListKey(QuestionListActivity::class)
    abstract fun bindQuestionListActivity(impl: QuestionListComponent.Builder): QuestionListComponentBuilder<*, *>
}