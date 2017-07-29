package www.breadboy.com.ctci.question3_animal_shelter

import dagger.Subcomponent
import www.breadboy.com.ctci.base.BaseComponent
import www.breadboy.com.ctci.base.QuestionComponentBuilder

/**
 * Created by N4039 on 2017-07-28.
 */

@AnimalShelterScope
@Subcomponent(modules = arrayOf(AnimalShelterModule::class))
interface AnimalShelterComponent : BaseComponent<AnimalShelterActivity> {

    @Subcomponent.Builder
    interface Builder : QuestionComponentBuilder<AnimalShelterModule, AnimalShelterComponent>
}