package www.breadboy.com.ctci

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by SDG on 2017. 7. 12..
 */
abstract class BaseActivity<T> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    abstract fun setupActivityComponent()

    fun startWithQuestion(startActivityContext: Context, desertActivity: Activity) {
        startActivityContext.startActivity(Intent(startActivityContext, Class.forName(desertActivity.packageName)))
    }
}