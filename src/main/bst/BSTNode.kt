package main.bst


class BSTNode<T : Comparable<T>, U>(var key : T, var value : U) {

    var parent : BSTNode<T, U>? = null

    var right : BSTNode<T, U>? = null

    var left : BSTNode<T, U>? = null

}