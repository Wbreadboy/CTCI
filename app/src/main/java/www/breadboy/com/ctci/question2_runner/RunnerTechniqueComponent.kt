package www.breadboy.com.ctci.question2_runner

import dagger.Subcomponent
import www.breadboy.com.ctci.base.BaseComponent
import www.breadboy.com.ctci.base.QuestionComponentBuilder

/**
 * Created by SDG on 2017. 7. 26..
 */

@RunnerTechScope
@Subcomponent(modules = arrayOf(RunnerTechniqueModule::class))
interface RunnerTechniqueComponent : BaseComponent<RunnerTechniqueActivity> {

    @Subcomponent.Builder
    interface Builder : QuestionComponentBuilder<RunnerTechniqueModule, RunnerTechniqueComponent>
}