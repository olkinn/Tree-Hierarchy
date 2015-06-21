/**
 * Created by olkinn on 6/3/15.
 */
trait IBinaryTree[T]{
  def add(newValue: T): BinaryTree[T]
  def inOrder()
  def postOrder()
  def preOrder()
}
