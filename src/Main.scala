/**
 * Created by olkinn on 6/10/15.
 */

object Main {
  def main (arg: Array[String]){
    val binaryTree = new BinaryTree[String]("String one", None, None)
    val newBinaryTree = binaryTree.add("test").add("lalala").add("alalal")

    println("postOrder traversal binary Tree: ")
    newBinaryTree.postOrder()
    println()

    val binarySearchTree = new BinarySearchTree[Double](0.009, None, None)
    val newBinarySearchTree = binarySearchTree.add(0.5).add(0).add(90).add(-7)

    println("inOrder traverasal BST: ")
    newBinarySearchTree.inOrder()
    newBinarySearchTree.search(90)
    println()

    val tree = new RedBlackTree[Int](0, None, None, false)
    val newRBTree = tree.add(6).add(5).add(4).add(3).add(2).add(8).add(9).add(1).add(23).add(7).add(-1)

    println("inOrder traversal RBTree: ")
    newRBTree.inOrder()
    println("postOrder traversal RBTree: ")
    newRBTree.postOrder()
    println("preOrder traversal RBTree: ")
    newRBTree.preOrder()

    newRBTree.search(10)
    println()
    println(newRBTree)
  }
}