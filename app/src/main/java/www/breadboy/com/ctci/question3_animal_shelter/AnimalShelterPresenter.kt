package www.breadboy.com.ctci.question3_animal_shelter

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

@Inject constructor(val animalShelterActivity: AnimalShelterActivity) : AnimalShelterContract.Presenter {

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
        val species = animalShelterActivity.edittext_choice_activity_animal_shelter.toString().trim().toLowerCase()
        val animal: Animal

        if ("dog" == species) {
            animal = animShelterQueue.removeDog()!!
        } else if ("cat" == species) {
            animal = animShelterQueue.removeCat()!!
        } else if ("any" == species) {
            animal = animShelterQueue.removeAny()
        } else {
            return "잘못 입력하셨습니다. dog, cat, any 중에 골라주세요."
        }

        chooseAnimal.append(animal.crying()).append(" - ").append(animal.name)

        return chooseAnimal.toString()
    }

    override fun printAnimalShelterQueue(animal: String) {
        animalShelterActivity.textview_activity_animal_shelter.setText(animal)
    }

    override fun clickInputBtn() {
        printAnimalShelterQueue(choiceAnimal())
    }
}