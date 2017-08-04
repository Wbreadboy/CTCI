package www.breadboy.com.ctci.question3_sort_stack

import dagger.Module
import dagger.Provides
import www.breadboy.com.ctci.base.BaseModule

/**
 * Created by N4039 on 2017-08-04.
 */

@Module
class SortStackModule(var sortStackActivity: SortStackActivity) : BaseModule<SortStackActivity>(sortStackActivity) {

    @SortStackScope
    @Provides
    fun provideSortStackActivity(): SortStackActivity {
        return sortStackActivity
    }

    @SortStackScope
    @Provides
    fun provideSortStackPresenter(sortStackActivity: SortStackActivity): SortStackContract.Presenter {
        return SortStackPresenter(sortStackActivity)
    }
}