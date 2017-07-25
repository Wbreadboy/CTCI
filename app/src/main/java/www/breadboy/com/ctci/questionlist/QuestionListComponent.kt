package www.breadboy.com.ctci.questionlist

import dagger.MembersInjector
import dagger.Subcomponent
import www.breadboy.com.ctci.base.BaseComponent
import www.breadboy.com.ctci.base.QuestionComponentBuilder

/**
 * Created by SDG on 2017. 7. 12..
 */

@ActivityScope
@Subcomponent(modules = arrayOf(QuestionListModule::class))
interface QuestionListComponent : BaseComponent<QuestionListActivity> {

    @Subcomponent.Builder
    interface Builder : QuestionComponentBuilder<QuestionListModule, QuestionListComponent>
}