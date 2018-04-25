package main.bst


class BST<T : Comparable<T>, U>() : IBST<T, U> {

    var size: Int = 0
        private set
    private var root : BSTNode<T, U>? = null

    private fun findNoteByKey(key : T) : BSTNode<T, U>? {
        fun findNode(node: BSTNode<T, U>?): BSTNode<T, U>? {
            if (node == null) return null
            if (key == node.key) return node
            if (key < node.key) {
                return findNode(node.left)
            }

            return findNode(node.right)
        }

        return findNode(root)
    }

    override fun find(key: T): U? {
        return findNoteByKey(key)?.value
    }

    override fun insert(key: T, value: U): Boolean {
        fun setParentByKey(node : BSTNode<T, U>?) : Boolean{
            if (key < node!!.key){
                if(node.left != null) return setParentByKey(node.left)
                node.left = BSTNode(key, value)
                node.left?.parent = node
                return true
            }
            if(key > node.key){
                if(node.right != null) return setParentByKey(node.right)
                node.right = BSTNode(key, value)
                node.right?.parent = node
                return true
            }
            return false
        }

        if(root == null){
            root = BSTNode(key, value)
            return true
        }
        return setParentByKey(root)
    }

    override fun remove(key: T): Boolean {

        fun removeElem(elem: BSTNode<T, U>?): Boolean {
            fun substitution(from : BSTNode<T, U>, to : BSTNode<T, U>?){
                val parent = from.parent
                if(parent == null)
                    root = to
                else if (parent.right == from)
                    parent.right = to
                else
                    parent.left = to
            }
            if (elem == null) return false
            if (elem.right == null && elem.left == null) {
                substitution(elem, null)
            }
            else if (elem.right == null)
                substitution(elem, elem.left)
            else if (elem.left == null)
                substitution(elem, elem.right)
            else {
                if (elem.right?.left == null) {
                    elem.key = elem.right?.key!!
                    elem.value = elem.right?.value!!
                    elem.right = elem.right?.right
                } else {
                    fun getMostLeftNode(node: BSTNode<T, U>?): BSTNode<T, U> {
                        if (node?.left != null)
                            return getMostLeftNode(node.left)
                        else return node!!
                    }

                    val mostLeft = getMostLeftNode(elem.right)
                    elem.value = mostLeft.value
                    elem.key = mostLeft.key
                    return removeElem(mostLeft)
                }
            }
            return true
        }
        return removeElem(findNoteByKey(key))

    }
}

