/**
 * Created by olkinn on 6/10/15.
 */
 class BinaryTree[T](val value: T, val left: Option[BinaryTree[T]], val right: Option[BinaryTree[T]]) extends IBinaryTree[T] {

  override def add(newValue: T): BinaryTree[T] = this match {
    case BinaryTree(value, None, None) =>
      new BinaryTree(value, Some(new BinaryTree(newValue, None, None)), None)
    case BinaryTree(value, left, None) =>
      new BinaryTree(value, left, Some(new BinaryTree(newValue, None, None)))
    case BinaryTree(value, Some(leftSubTree), right) =>
      new BinaryTree(value, Option(leftSubTree.add(newValue)), right)
  }

  def inOrder(): Unit = this match {
    case BinaryTree(value, None, None) => {
      println(this.value)
    }
    case BinaryTree(value, Some(leftSubTree), None) => {
      leftSubTree.inOrder()
      println(this.value)
    }
    case BinaryTree(value, None, Some(rightSubTree)) => {
      println(this.value)
      rightSubTree.inOrder()
    }
    case BinaryTree(value, Some(leftSubTree), Some(rightSubTree)) => {
      leftSubTree.inOrder()
      println(this.value)
      rightSubTree.inOrder()
    }
  }

  def preOrder(): Unit = this match {
    case BinaryTree(value, None, None) => {
      println(this.value)
    }
    case BinaryTree(value, Some(leftSubTree), None) => {
      println(this.value)
      leftSubTree.preOrder()
    }
    case BinaryTree(value, None, Some(rightSubTree)) => {
      println(this.value)
      rightSubTree.preOrder()
    }
    case BinaryTree(value, Some(leftSubTree), Some(rightSubTree)) => {
      println(this.value)
      leftSubTree.preOrder()
      rightSubTree.preOrder()
    }
  }

  def postOrder(): Unit = this match {
    case BinaryTree(value, None, None) => {
      println(this.value)
    }
    case BinaryTree(value, Some(leftSubTree), None) => {
      leftSubTree.postOrder()
      println(this.value)
    }
    case BinaryTree(value, None, Some(rightSubTree)) => {
      rightSubTree.postOrder()
      println(this.value)
    }
    case BinaryTree(value, Some(leftSubTree), Some(rightSubTree)) => {
      leftSubTree.postOrder()
      rightSubTree.postOrder()
      println(this.value)
    }
  }

}
  object BinaryTree{
    def unapply[T](tree: BinaryTree[T]): Option[(T, Option[BinaryTree[T]], Option[BinaryTree[T]])] =
      Some((tree.value, tree.left, tree.right))
  }

//Case classes are regular classes which export their constructor parameters and which
// provide a recursive decomposition mechanism via pattern matching.
