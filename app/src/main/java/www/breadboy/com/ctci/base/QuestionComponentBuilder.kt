package www.breadboy.com.ctci.base

/**
 * Created by N4039 on 2017-07-20.
 */

interface QuestionComponentBuilder<M : BaseModule<*>, C : BaseComponent<*>> {
    fun questionMoudule(module: M): QuestionComponentBuilder<M, C>
    fun build(): C
}