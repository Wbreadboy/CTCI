package www.breadboy.com.ctci.question3_animal_shelter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_animal_shelter.*

import www.breadboy.com.ctci.R
import www.breadboy.com.ctci.application.CtciApplication
import javax.inject.Inject

class AnimalShelterActivity : AnimalShelterContract.View(), View.OnClickListener {

    @Inject
    lateinit var animalShelterPresenter: AnimalShelterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_animal_shelter)
        setupActivityComponent()
    }

    override fun onResume() {
        super.onResume()

        animalShelterPresenter.start()
    }

    override fun initView() {
        btn_activity_animal_shelter.setOnClickListener(this)
    }

    override fun setupActivityComponent() {
        (CtciApplication[this].getQuestionComponentBuilder(AnimalShelterActivity::class.java) as AnimalShelterComponent.Builder)
                .questionMoudule(AnimalShelterModule(this))
                .build()
                .injectMembers(this)
    }

    override fun onClick(view: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
