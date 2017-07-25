package www.breadboy.com.ctci.questionlist

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.questionlist_cardview.view.*

/**
 * Created by SDG on 2017. 7. 12..
 */
class QuestionListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var titleTextView: TextView

    fun bind() =
            with(itemView) {
                titleTextView = qustionlist_title
            }
}