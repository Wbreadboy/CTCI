package www.breadboy.com.ctci.questionlist

import www.breadboy.com.ctci.data.Question
import www.breadboy.com.ctci.question2_runner.RunnerTechniqueActivity
import www.breadboy.com.ctci.question3_animal_shelter.AnimalShelterActivity
import www.breadboy.com.ctci.question3_sort_stack.SortStackActivity
import www.breadboy.com.ctci.question4_minimal_tree.MinimalTreeActivity
import javax.inject.Inject

/**
 * Created by SDG on 2017. 7. 12..
 */

@ActivityScope
class QuestionListPresenter

@Inject
constructor(val questionListActivity: QuestionListActivity) : QuestionListContract.Presenter {

    override fun start() {
        questionListActivity.questionListAdapter.addQuestion(Question(RunnerTechniqueActivity(), "2 - Runner Technique"))
        questionListActivity.questionListAdapter.addQuestion(Question(AnimalShelterActivity(), "3.6 - Animal Shelter"))
        questionListActivity.questionListAdapter.addQuestion(Question(SortStackActivity(), "3.5 - Sort Stack"))
        questionListActivity.questionListAdapter.addQuestion(Question(MinimalTreeActivity(), "4.3 - Minimal Tree"))
    }
}