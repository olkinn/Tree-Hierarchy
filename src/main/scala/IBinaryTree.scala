/**
 * Created by olkinn on 6/3/15.
 */
trait IBinaryTree[T]{
  def add(newValue: T): BinaryTree[T]
  def inOrder()
  def postOrder()
  def preOrder()
  def printTree()
  def callInOrder(f: (T, Int) => Unit, depth: Int = 0) : Unit
}
