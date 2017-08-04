package www.breadboy.com.ctci.question3_animal_shelter

import android.util.Log
import kotlinx.android.synthetic.main.activity_animal_shelter.*
import www.breadboy.com.ctci.question3_animal_shelter.queue.Queue
import www.breadboy.com.ctci.question3_animal_shelter.data.Animal
import www.breadboy.com.ctci.question3_animal_shelter.data.Cat
import www.breadboy.com.ctci.question3_animal_shelter.data.Dog
import javax.inject.Inject

/**
 * Created by N4039 on 2017-07-28.
 */

class AnimalShelterPresenter

@Inject
constructor(val animalShelterActivity: AnimalShelterActivity) : AnimalShelterContract.Presenter {

    lateinit var animShelterQueue: Queue<Animal>

    override fun start() {
        initQueue()
        inputNodeToEditText()

        printAnimalShelterQueue(animShelterQueue.toString())
    }

    override fun initQueue() {
        animShelterQueue = Queue()
    }

    override fun inputNodeToEditText() {
        animShelterQueue.add(Dog(animalShelterActivity, "골든 리트리버"))
        animShelterQueue.add(Cat(animalShelterActivity, "페르시안"))
        animShelterQueue.add(Dog(animalShelterActivity, "치와와"))
        animShelterQueue.add(Cat(animalShelterActivity, "뱅갈"))
        animShelterQueue.add(Cat(animalShelterActivity, "블랙러시안"))
        animShelterQueue.add(Cat(animalShelterActivity, "먼치킨"))
        animShelterQueue.add(Dog(animalShelterActivity, "불독"))
    }

    override fun choiceAnimal(): String {
        val chooseAnimal = StringBuilder()
        val species = animalShelterActivity.edittext_activity_animal_shelter.text.toString().trim().toLowerCase()
        val animal: Animal

        try {
            when (species) {
                "dog" -> animal = animShelterQueue.removeDog()!!
                "cat" -> animal = animShelterQueue.removeCat()!!
                "any" -> animal = animShelterQueue.removeAny()
                else -> return "잘못 입력하셨습니다. dog, cat, any 중에 골라주세요. \n\n $animShelterQueue"
            }

            chooseAnimal.append(animal.name).append(" - ").append(animal.crying()).append("\n\n").append(animShelterQueue.toString())
        } catch (e: NoSuchElementException) {
            chooseAnimal.append("해당 동물은 더이상 없습니다.").append("\n\n").append(animShelterQueue.toString())

            e.stackTrace
        }

        return chooseAnimal.toString()
    }

    override fun printAnimalShelterQueue(animal: String) {
        animalShelterActivity.textview_activity_animal_shelter.setText(animal)
    }

    override fun clickInputBtn() {
        printAnimalShelterQueue(choiceAnimal())
    }
}