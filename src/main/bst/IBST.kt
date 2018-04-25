package main.bst

interface IBST<in T : Comparable<T>, U> {
    fun find(key : T) : U?
    fun insert(key : T, value: U) : Boolean
    fun remove(key : T) : Boolean
}