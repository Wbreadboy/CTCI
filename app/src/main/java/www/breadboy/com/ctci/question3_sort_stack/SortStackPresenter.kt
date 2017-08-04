package www.breadboy.com.ctci.question3_sort_stack

import kotlinx.android.synthetic.main.activity_sort_stack.*
import www.breadboy.com.ctci.question3_sort_stack.stack.SortStack
import javax.inject.Inject

/**
 * Created by N4039 on 2017-08-04.
 */

class SortStackPresenter

@Inject
constructor(val sortStackActivity: SortStackActivity) : SortStackContract.Presenter {

    lateinit var sortStack: SortStack<String>

    override fun start() {
        initSortStack()
    }

    override fun initSortStack() {
        sortStack = SortStack()
    }

    override fun pushSortStack() {
        sortStack.push(sortStackActivity.edittext_activity_sort_stack.text.toString())
    }

    override fun printSortStack() {
        sortStackActivity.textview_activity_sort_stack.setText(sortStack.toString())
    }

    override fun clearEditText() {
        sortStackActivity.edittext_activity_sort_stack.text.clear()
    }

    override fun clickInputBtn() {
        pushSortStack()
        printSortStack()
        clearEditText()
    }
}