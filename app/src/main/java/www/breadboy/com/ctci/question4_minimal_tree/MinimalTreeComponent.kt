package www.breadboy.com.ctci.question4_minimal_tree

import dagger.Component
import dagger.Subcomponent
import www.breadboy.com.ctci.base.BaseComponent
import www.breadboy.com.ctci.base.QuestionComponentBuilder
import www.breadboy.com.ctci.data.Question

/**
 * Created by N4039 on 2017-08-14.
 */

@MinimalTreeScope
@Subcomponent(modules = arrayOf(MinimalTreeModule::class))
interface MinimalTreeComponent : BaseComponent<MinimalTreeActivity> {

    @Subcomponent.Builder
    interface Builder : QuestionComponentBuilder<MinimalTreeModule, MinimalTreeComponent>
}