package www.breadboy.com.ctci.question4_minimal_tree

import dagger.Module
import dagger.Provides
import www.breadboy.com.ctci.base.BaseModule

/**
 * Created by N4039 on 2017-08-14.
 */

@Module
class MinimalTreeModule(var minimalTreeActivity: MinimalTreeActivity) : BaseModule<MinimalTreeActivity>(minimalTreeActivity) {

    @MinimalTreeScope
    @Provides
    fun provideMinimalTreeActivity(): MinimalTreeActivity {
        return minimalTreeActivity
    }

    @MinimalTreeScope
    @Provides
    fun provideMinimalTreePresenter(minimalTreeActivity: MinimalTreeActivity): MinimalTreeContract.Presenter {
        return MinimalTreePresenter(minimalTreeActivity)
    }
}