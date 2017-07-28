package www.breadboy.com.ctci.question3_animal_shelter

import www.breadboy.com.ctci.base.BaseActivity
import www.breadboy.com.ctci.base.BasePresenter

/**
 * Created by N4039 on 2017-07-28.
 */
interface AnimalShelterContract {

    abstract class View : BaseActivity<Presenter>()

    interface Presenter : BasePresenter {

        fun initQueue()

        fun inputNodeToEditText()

        fun choiceAnimal(): String

        fun printAnimalShelterQueue(animal: String)

        fun clickInputBtn()
    }
}