/**
 * Created by olkinn on 6/20/15.
 */
trait IRedBlackTree[T] {
  def balance(b: Boolean, x: T, l: Option[RedBlackTree[T]], r: Option[RedBlackTree[T]]): RedBlackTree[T]
}
