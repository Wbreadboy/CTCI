package www.breadboy.com.ctci.base

import android.app.Activity
import dagger.MembersInjector

/**
 * Created by SDG on 2017. 7. 26..
 */

interface BaseComponent<A: Activity> : MembersInjector<A>