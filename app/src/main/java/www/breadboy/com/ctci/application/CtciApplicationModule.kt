package www.breadboy.com.ctci.application

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import www.breadboy.com.ctci.base.QuestionActivityKey
import www.breadboy.com.ctci.base.QuestionComponentBuilder
import www.breadboy.com.ctci.question2_runner.RunnerTechniqueActivity
import www.breadboy.com.ctci.question2_runner.RunnerTechniqueComponent
import www.breadboy.com.ctci.question3_animal_shelter.AnimalShelterActivity
import www.breadboy.com.ctci.question3_animal_shelter.AnimalShelterComponent
import www.breadboy.com.ctci.question3_sort_stack.SortStackActivity
import www.breadboy.com.ctci.question3_sort_stack.SortStackComponent
import www.breadboy.com.ctci.question4_minimal_tree.MinimalTreeActivity
import www.breadboy.com.ctci.question4_minimal_tree.MinimalTreeComponent
import www.breadboy.com.ctci.questionlist.QuestionListActivity
import www.breadboy.com.ctci.questionlist.QuestionListComponent

/**
 * Created by SDG on 2017. 7. 18..
 */

@Module(subcomponents = arrayOf(
        QuestionListComponent::class,
        RunnerTechniqueComponent::class,
        AnimalShelterComponent::class,
        SortStackComponent::class,
        MinimalTreeComponent::class))

abstract class CtciApplicationModule {

    @Binds
    @IntoMap
    @QuestionActivityKey(QuestionListActivity::class)
    abstract fun bindQuestionListActivity(impl: QuestionListComponent.Builder): QuestionComponentBuilder<*, *>

    @Binds
    @IntoMap
    @QuestionActivityKey(RunnerTechniqueActivity::class)
    abstract fun bindRunnerTechniqueActivity(impl: RunnerTechniqueComponent.Builder): QuestionComponentBuilder<*, *>

    @Binds
    @IntoMap
    @QuestionActivityKey(AnimalShelterActivity::class)
    abstract fun bindAnimalShelterActivity(impl: AnimalShelterComponent.Builder): QuestionComponentBuilder<*, *>

    @Binds
    @IntoMap
    @QuestionActivityKey(SortStackActivity::class)
    abstract fun bindSortStackActivity(impl: SortStackComponent.Builder): QuestionComponentBuilder<*, *>

    @Binds
    @IntoMap
    @QuestionActivityKey(MinimalTreeActivity::class)
    abstract fun bindMinimalTreeActivity(impl: MinimalTreeComponent.Builder): QuestionComponentBuilder<*, *>
}