package www.breadboy.com.ctci.questionlist

/**
 * Created by N4039 on 2017-07-20.
 */

interface QuestionListComponentBuilder<M : QuestionListModule, C : QuestionListComponent> {
    fun questionListMoudule(module: M): QuestionListComponentBuilder<M, C>
    fun build(): C
}