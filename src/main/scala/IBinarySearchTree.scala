/**
 * Created by olkinn on 6/12/15.
 */
trait IBinarySearchTree[T] extends BinaryTree[T] with IBinaryTree[T]{
  def search(value: T)(implicit ordering: Ordering[T])
}
