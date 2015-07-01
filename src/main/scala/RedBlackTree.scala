/**
 * Created by olkinn on 6/17/15.
 */
case class RedBlackTree[T](override val value: T, override val left: Option[RedBlackTree[T]], override val right: Option[RedBlackTree[T]], val isBlack: Boolean)
  extends BinarySearchTree[T](value: T, left: Option[BinarySearchTree[T]], right: Option[BinarySearchTree[T]]) with IRedBlackTree[T]{

  private def addTo(t: Option[RedBlackTree[T]], x: T)(implicit ordering: Ordering[T]): RedBlackTree[T] = t match {
    case None =>
      RedBlackTree(x, None, None, false)
    case Some(RedBlackTree(v, l, r, b)) if (ordering.eq(x, v)) =>
      RedBlackTree(v, l, r, b)
    case Some(RedBlackTree(v, l, r, b)) if (ordering.lt(x, v)) =>
      balance(b, v, Some(addTo(l, x)), r)
    case Some(RedBlackTree(v, l, r, b)) if (ordering.gt(x, v)) =>
      balance(b, v, l, Some(addTo(r, x)))
  }

  override def add(x: T)(implicit ordering: Ordering[T]): RedBlackTree[T] = {
    makeBlack(addTo(Some(this), x))
  }

  def balance(b: Boolean, z: T, l: Option[RedBlackTree[T]], r: Option[RedBlackTree[T]]): RedBlackTree[T] =  (b, l, r) match {
    // Black, has left red that has left red
    case (true, Some(RedBlackTree(y, Some(RedBlackTree(x, a, b, false)), c, false)), d)=>
      RedBlackTree(y, Some(RedBlackTree(x, a, b, true)), Some(RedBlackTree(z, c, d, true)), false)

    // Black, has left red that has right red
    case (true, Some(RedBlackTree(x, a, Some(RedBlackTree(y, b, c, false)), false)), d) =>
      RedBlackTree(y, Some(RedBlackTree(x, a, b, true)), Some(RedBlackTree(z, c, d, true)), false)

    // Black, has right red has left red
    case (true, a, Some(RedBlackTree(x, Some(RedBlackTree(y, b, c, false)), d, false))) =>
      RedBlackTree(y, Some(RedBlackTree(z, a, b, true)), Some(RedBlackTree(x, c, d, true)), false)

    // right red has right red
    case (true, a, Some(RedBlackTree(y, b, Some(RedBlackTree(x, c, d, false)), false))) =>
      RedBlackTree(y, Some(RedBlackTree(z, a, b, true)), Some(RedBlackTree(x, c, d, true)), false)

    case (color, left, right) =>
      RedBlackTree(z, left, right, color)
  }

  private def makeBlack(tree: RedBlackTree[T]) = tree match {
    case RedBlackTree(v, l, r, _) => RedBlackTree(v, l, r, true)
  }

}