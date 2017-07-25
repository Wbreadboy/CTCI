package www.breadboy.com.ctci.application

import dagger.Component
import javax.inject.Singleton

/**
 * Created by SDG on 2017. 7. 18..
 */

@Singleton
@Component(modules = arrayOf(CtciApplicationModule::class))
interface CtciApplicationComponent {
    fun inject(ctciApplication: CtciApplication): CtciApplication
}