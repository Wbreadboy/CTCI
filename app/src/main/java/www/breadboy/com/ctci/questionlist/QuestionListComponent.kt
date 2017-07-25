package www.breadboy.com.ctci.questionlist

import dagger.MembersInjector
import dagger.Subcomponent
import www.breadboy.com.ctci.ActivityScope

/**
 * Created by SDG on 2017. 7. 12..
 */

@ActivityScope
@Subcomponent(modules = arrayOf(QuestionListModule::class))
interface QuestionListComponent : MembersInjector<QuestionListActivity> {

    @Subcomponent.Builder
    interface Builder : QuestionListComponentBuilder<QuestionListModule, QuestionListComponent>
}