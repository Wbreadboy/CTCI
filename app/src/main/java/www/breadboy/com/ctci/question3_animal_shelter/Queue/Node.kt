package www.breadboy.com.ctci.question3_animal_shelter.Queue

/**
 * Created by SDG on 2017. 7. 28..
 */

class Node<A>(data: A) {
    var data: A = data

    var next: Node<A>? = null
    var previous: Node<A>? = null
}