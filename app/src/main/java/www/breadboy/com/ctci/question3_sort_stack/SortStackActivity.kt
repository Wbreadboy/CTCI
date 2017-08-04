package www.breadboy.com.ctci.question3_sort_stack

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sort_stack.*
import www.breadboy.com.ctci.R
import www.breadboy.com.ctci.application.CtciApplication
import javax.inject.Inject

class SortStackActivity : SortStackContract.View(), View.OnClickListener {

    @Inject
    lateinit var sortStackPresenter: SortStackPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sort_stack)
        setupActivityComponent()

        initView()
    }

    override fun onResume() {
        super.onResume()

        sortStackPresenter.start()
    }

    override fun setupActivityComponent() {
        (CtciApplication[this].getQuestionComponentBuilder(SortStackActivity::class.java) as SortStackComponent.Builder)
                .questionMoudule(SortStackModule(this))
                .build()
                .injectMembers(this)
    }

    private fun initView() {
        btn_activity_sort_stack.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            btn_activity_sort_stack -> sortStackPresenter.clickInputBtn()
        }
    }
}
