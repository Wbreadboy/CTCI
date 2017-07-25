package www.breadboy.com.ctci.questionlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import www.breadboy.com.ctci.base.BaseActivity
import www.breadboy.com.ctci.R
import www.breadboy.com.ctci.data.Question
import javax.inject.Inject

/**
 * Created by SDG on 2017. 7. 12..
 */

@ActivityScope
class QuestionListAdapter

@Inject constructor(
        val questionListActivity: QuestionListActivity,
        val questionListPresenter: QuestionListContract.Presenter) : RecyclerView.Adapter<QuestionListViewHolder>() {

    private var QuestionsArrList: ArrayList<Question> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =  QuestionListViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.questionlist_cardview, parent, false))

    override fun onBindViewHolder(holder: QuestionListViewHolder?, position: Int) {
        holder?.bind()
        holder?.titleTextView?.setText(QuestionsArrList.get(position).title)
        holder?.titleTextView?.setOnClickListener { QuestionsArrList.get(position).questionActivity?.let { it1 -> onQuesionListClicked(it1) } }
    }

    fun onQuesionListClicked(questionActivity: BaseActivity<*>) {
        questionListPresenter.onQuestionClick(questionListActivity, questionActivity)
    }

    override fun getItemCount(): Int {
        return QuestionsArrList.size
    }

    fun addQuestion(question: Question) {
        QuestionsArrList.add(question)
    }

    fun addQuestions(questions: List<Question>) {
        QuestionsArrList.addAll(questions)
    }

    fun clear() {
        QuestionsArrList.clear()
    }

    fun removeQuestion(question: Question) {
        QuestionsArrList.remove(question)
    }

    fun getItem(position: Int) = QuestionsArrList.getOrNull(position)

    fun getItems() = QuestionsArrList
}