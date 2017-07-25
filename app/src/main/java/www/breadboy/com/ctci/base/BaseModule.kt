package www.breadboy.com.ctci.base

import android.app.Activity
import dagger.Module

/**
 * Created by SDG on 2017. 7. 26..
 */

@Module
abstract class BaseModule<out T : Activity>(val activity: T)