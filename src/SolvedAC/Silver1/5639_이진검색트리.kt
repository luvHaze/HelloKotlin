package SolvedAC.Silver1

fun main() {
    val tree = TreeB()
    while (true) {
        val value = readLine()
        if(value == null || value == "") {
            break
        } else {
            tree.insert(value.toInt())
        }
    }

    tree.postOrder(tree.mRoot!!)
}
private class NodeB(
    val value: Int,
    var left: NodeB?,
    var right: NodeB?
)

private class TreeB() {
    private var _root: NodeB? = null
    val mRoot get() = _root

    fun insert(value: Int) {
        if(_root == null) {
            _root = NodeB(value, null, null)
        } else {
            search(_root, value)
        }
    }

    fun search(root: NodeB?, value: Int) {
        if(root == null) return
        if (root.left == null && root.value > value) {
            root.left = NodeB(value, null, null)
        } else if (root.right == null && root.value < value) {
            root.right = NodeB(value, null, null)
        } else {
            if(value < root.value) search(root.left, value)
            if(value > root.value) search(root.right, value)
        }
    }

    fun postOrder(root: NodeB) {
        if(root.left != null) postOrder(root.left!!)
        if(root.right != null) postOrder(root.right!!)
        println(root.value)
    }
}