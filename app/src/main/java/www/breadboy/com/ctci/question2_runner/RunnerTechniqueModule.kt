package www.breadboy.com.ctci.question2_runner

import dagger.Module
import dagger.Provides
import www.breadboy.com.ctci.base.BaseModule

/**
 * Created by SDG on 2017. 7. 26..
 */

@Module
class RunnerTechniqueModule(var runnerTechniqueActivity: RunnerTechniqueActivity) : BaseModule<RunnerTechniqueActivity>(runnerTechniqueActivity) {

    @RunnerTechScope
    @Provides
    fun provideRunnerTechniqueActivity(): RunnerTechniqueActivity {
        return runnerTechniqueActivity
    }

    @RunnerTechScope
    @Provides
    fun provideRunnerTechniquePresenter(runnerTechniqueActivity: RunnerTechniqueActivity): RunnerTechniqueContract.Presenter {
        return RunnerTechniquePresenter(runnerTechniqueActivity)
    }
}