package www.breadboy.com.ctci.application

import android.app.Activity
import android.app.Application
import android.content.Context
import www.breadboy.com.ctci.questionlist.HasQuestionListComponentBuilders
import www.breadboy.com.ctci.questionlist.QuestionListComponentBuilder
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by SDG on 2017. 7. 12..
 */
class CtciApplication : Application(), HasQuestionListComponentBuilders {

    lateinit var ctciApplicationComponent: CtciApplicationComponent

    @Inject
    lateinit var questionListComponentBuilders: Map<Class<out Activity>, @JvmSuppressWildcards Provider<QuestionListComponentBuilder<*, *>>>

    override fun onCreate() {
        super.onCreate()

        initCdciApplicationComponent()
    }

    fun initCdciApplicationComponent() {
        ctciApplicationComponent = DaggerCtciApplicationComponent.create()
        ctciApplicationComponent.inject(this)
    }

    fun getCdciAppComponent(): CtciApplicationComponent {
        return ctciApplicationComponent
    }

    override fun getQuestionListComponentBuilder(activity: Class<out Activity>): QuestionListComponentBuilder<*, *> {
        return questionListComponentBuilders[activity]!!.get()
    }

    companion object {
        operator fun get(context: Context): HasQuestionListComponentBuilders {
            return context.applicationContext as HasQuestionListComponentBuilders
        }
    }
}