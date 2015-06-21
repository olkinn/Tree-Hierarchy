/**
 * Created by olkinn on 6/12/15.
 */
class BinarySearchTree[T](override val value: T, override val left: Option[BinarySearchTree[T]], override val right: Option[BinarySearchTree[T]])
  extends BinaryTree[T](value, left, right) with IBinarySearchTree[T] {

  def search(searchValue: T)(implicit ordering: Ordering[T]): Unit = this match {
    case BinarySearchTree(value, None, None) => {
      if (searchValue.equals(value)) {
        println(searchValue + " found")
        return
      }
      else println(searchValue + " not found")
    }
    case BinarySearchTree(value, Some(leftSubTree), None) => {
      if (searchValue.equals(value)) {
        println(searchValue + " found")
        return
      }
      if (ordering.gt(searchValue, value)) {
        println(searchValue + " not found")
      }
      else leftSubTree.search(searchValue)
    }
    case BinarySearchTree(value, None, Some(rightSubTree)) => {
      if (searchValue.equals(value)) {
        println(searchValue + " found")
        return
      }
      if (ordering.gt(searchValue, value)) {
        rightSubTree.search(searchValue)
      }
      else println(searchValue + " not found")
    }
    case BinarySearchTree(value, Some(leftSubTree), Some(rightSubTree)) => {
      if (searchValue.equals(value)) {
        println(searchValue + " found")
        return
      }
      if (ordering.gt(searchValue, value)) {
        rightSubTree.search(searchValue)
      }
      else leftSubTree.search(searchValue)
    }
  }


  def add(newValue: T)(implicit ordering: Ordering[T]): BinarySearchTree[T] = this match {
    case BinarySearchTree(value, None, None) => {
      if (ordering.gt(newValue, value)) {
        new BinarySearchTree(value, None, Some(new BinarySearchTree(newValue, None, None)))
      }
      else new BinarySearchTree(value, Some(new BinarySearchTree(newValue, None, None)), None)
    }
    case BinarySearchTree(value, Some(leftSubTree), None) => {
      if (ordering.gt(newValue, value)) {
        new BinarySearchTree(value, Some(leftSubTree), Some(new BinarySearchTree(newValue, None, None)))
      }
      else new BinarySearchTree(value, Option(leftSubTree.add(newValue)), None)
    }
    case BinarySearchTree(value, None, Some(rightSubTree)) => {
      if (ordering.gt(newValue, value)) {
        new BinarySearchTree(value, None, Option(rightSubTree.add(newValue)))
      }
      else new BinarySearchTree(value, Some(new BinarySearchTree(newValue, None, None)), Some(rightSubTree))
    }
    case BinarySearchTree(value, Some(leftSubTree), Some(rightSubTree)) => {
      if (ordering.gt(newValue, value)) {
        new BinarySearchTree(value, Some(leftSubTree), Some(rightSubTree.add(newValue)))
      }
      else new BinarySearchTree(value, Option(leftSubTree.add(newValue)), Some(rightSubTree))
    }
  }
}

object BinarySearchTree{
  def unapply[T](tree: BinarySearchTree[T]): Option[(T, Option[BinarySearchTree[T]], Option[BinarySearchTree[T]])] =
    Some((tree.value, tree.left, tree.right))
}