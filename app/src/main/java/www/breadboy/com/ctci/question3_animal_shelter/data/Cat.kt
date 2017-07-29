package www.breadboy.com.ctci.question3_animal_shelter.data

import android.content.Context
import www.breadboy.com.ctci.R

/**
 * Created by N4039 on 2017-07-28.
 */

data class Cat(val context: Context, override val name: String) : Animal {

    override fun crying(): String {
        return context.getString(R.string.cat_crying)
    }

    override fun toString(): String {
        return name
    }
}