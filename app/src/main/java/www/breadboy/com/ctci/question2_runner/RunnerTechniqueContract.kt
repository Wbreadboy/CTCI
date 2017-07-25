package www.breadboy.com.ctci.question2_runner

import www.breadboy.com.ctci.BaseActivity
import www.breadboy.com.ctci.BasePresenter

/**
 * Created by N4039 on 2017-07-25.
 */
interface RunnerTechniqueContract {
    abstract class View : BaseActivity<Presenter>()

    interface Presenter : BasePresenter
}