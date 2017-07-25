package www.breadboy.com.ctci.base

import android.app.Activity
import kotlin.reflect.KClass

/**
 * Created by N4039 on 2017-07-20.
 */
interface HasQuestionSubcomponentBuilders {
    fun getQuestionComponentBuilder(activity: Class<out Activity>): QuestionComponentBuilder<*, *>
}