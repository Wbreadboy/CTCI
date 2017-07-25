package www.breadboy.com.ctci.questionlist

import android.app.Activity
import kotlin.reflect.KClass

/**
 * Created by N4039 on 2017-07-20.
 */
interface HasQuestionListComponentBuilders {
    fun getQuestionListComponentBuilder(activity: Class<out Activity>): QuestionListComponentBuilder<*, *>
}