package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val tree = init()

    tree.preOrder(tree.mRoot!!)
    println()
    tree.inOrder(tree.mRoot!!)
    println()
    tree.postOrder(tree.mRoot!!)
}

private fun init(): Tree {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val tree = Tree()
    repeat(N) {
        val tk = StringTokenizer(br.readLine())
        val value = tk.nextToken()[0]
        val left = tk.nextToken()[0]
        val right = tk.nextToken()[0]
        tree.insert(value, left, right)
    }

    return tree
}

private class TreeNode(
    val value: Char,
    var left: TreeNode?,
    var right: TreeNode?
) {
    companion object {
        fun makeNode(value: Char, left: Char, right: Char): TreeNode {
            val node = TreeNode(value, null, null)
            if (left != '.') {
                node.left = TreeNode(left, null, null)
            }
            if (right != '.') {
                node.right = TreeNode(right, null, null)
            }

            return node
        }
    }
}

private class Tree() {
    private var _root: TreeNode? = null
    val mRoot get() = _root

    fun insert(value: Char, left: Char, right: Char) {
        if (_root == null) {
            _root = TreeNode.makeNode(value, left, right)
        } else {
            search(_root!!, value, left, right)
        }
    }

    private fun search(root: TreeNode?, value: Char, left: Char, right: Char) {
        if (root == null) return

        when {
            root.left?.value == value -> {
                root.left = TreeNode.makeNode(value, left, right)
            }
            root.right?.value == value -> {
                root.right = TreeNode.makeNode(value, left, right)
            }
            else -> {
                search(root.left, value, left, right)
                search(root.right, value, left, right)
            }
        }
    }

    fun preOrder(root: TreeNode) {
        print(root.value)
        if (root.left != null) preOrder(root.left!!)
        if (root.right != null) preOrder(root.right!!)
    }

    fun inOrder(root: TreeNode) {
        if (root.left != null) inOrder(root.left!!)
        print(root.value)
        if (root.right != null) inOrder(root.right!!)
    }

    fun postOrder(root: TreeNode) {
        if (root.left != null) postOrder(root.left!!)
        if (root.right != null) postOrder(root.right!!)
        print(root.value)
    }
}