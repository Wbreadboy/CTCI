package www.breadboy.com.ctci.application

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import www.breadboy.com.ctci.base.QuestionActivityKey
import www.breadboy.com.ctci.base.QuestionComponentBuilder
import www.breadboy.com.ctci.question2_runner.RunnerTechniqueActivity
import www.breadboy.com.ctci.question2_runner.RunnerTechniqueComponent
import www.breadboy.com.ctci.questionlist.QuestionListActivity
import www.breadboy.com.ctci.questionlist.QuestionListComponent

/**
 * Created by SDG on 2017. 7. 18..
 */

@Module(subcomponents = arrayOf(QuestionListComponent::class, RunnerTechniqueComponent::class))
abstract class CtciApplicationModule {

    @Binds
    @IntoMap
    @QuestionActivityKey(QuestionListActivity::class)
    abstract fun bindQuestionListActivity(impl: QuestionListComponent.Builder): QuestionComponentBuilder<*, *>

    @Binds
    @IntoMap
    @QuestionActivityKey(RunnerTechniqueActivity::class)
    abstract fun bindRunnerTechniqueActivity(impl: RunnerTechniqueComponent.Builder): QuestionComponentBuilder<*, *>
}