package www.breadboy.com.ctci.question3_animal_shelter.data

import android.app.Application
import android.content.Context
import www.breadboy.com.ctci.R
import www.breadboy.com.ctci.application.CtciApplication

/**
 * Created by N4039 on 2017-07-28.
 */

data class Dog(val context: Context, override val name: String) : Animal {

    override fun crying(): String {
        return context.getString(R.string.dog_crying)
    }

    override fun toString(): String {
        return name
    }
}