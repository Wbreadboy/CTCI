package www.breadboy.com.ctci.question3_sort_stack

import dagger.Subcomponent
import www.breadboy.com.ctci.base.BaseComponent
import www.breadboy.com.ctci.base.QuestionComponentBuilder

/**
 * Created by N4039 on 2017-08-04.
 */

@SortStackScope
@Subcomponent(modules = arrayOf(SortStackModule::class))
interface SortStackComponent : BaseComponent<SortStackActivity> {

    @Subcomponent.Builder
    interface Builder : QuestionComponentBuilder<SortStackModule, SortStackComponent>
}