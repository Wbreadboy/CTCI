package www.breadboy.com.ctci.question3_animal_shelter.Queue

/**
 * Created by SDG on 2017. 7. 28..
 */

class Node<T>(data: T) {
    var data: T = data
    var next: Node<T>? = null
}