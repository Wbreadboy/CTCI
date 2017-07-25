package www.breadboy.com.ctci.questionlist

import android.app.Activity
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by SDG on 2017. 7. 18..
 */

@MapKey
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class QuestionListKey(val value: KClass<out Activity>)