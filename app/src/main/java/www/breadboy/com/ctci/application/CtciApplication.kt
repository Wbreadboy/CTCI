package www.breadboy.com.ctci.application

import android.app.Activity
import android.app.Application
import android.content.Context
import www.breadboy.com.ctci.base.HasQuestionSubcomponentBuilders
import www.breadboy.com.ctci.base.QuestionComponentBuilder
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by SDG on 2017. 7. 12..
 */
class CtciApplication : Application(), HasQuestionSubcomponentBuilders {

    lateinit var ctciApplicationComponent: CtciApplicationComponent

    @Inject
    lateinit var questionComponentBuilders: Map<Class<out Activity>, @JvmSuppressWildcards Provider<QuestionComponentBuilder<*, *>>>

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

    override fun getQuestionComponentBuilder(activity: Class<out Activity>): QuestionComponentBuilder<*, *> {
        return questionComponentBuilders[activity]!!.get()
    }

    companion object {
        operator fun get(context: Context): HasQuestionSubcomponentBuilders {
            return context.applicationContext as HasQuestionSubcomponentBuilders
        }
    }
}