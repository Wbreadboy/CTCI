package www.breadboy.com.ctci.question3_animal_shelter

import dagger.Module
import dagger.Provides
import www.breadboy.com.ctci.base.BaseModule

/**
 * Created by N4039 on 2017-07-28.
 */

@Module
class AnimalShelterModule(var animalShelterActivity: AnimalShelterActivity) : BaseModule<AnimalShelterActivity>(animalShelterActivity) {

    @AnimalShelterScope
    @Provides
    fun provideAnimalShelterActivity(): AnimalShelterActivity {
        return animalShelterActivity
    }

    @AnimalShelterScope
    @Provides
    fun provideAnimalShelterPresenter(animalShelterActivity: AnimalShelterActivity): AnimalShelterContract.Presenter {
        return AnimalShelterPresenter(animalShelterActivity)
    }
}