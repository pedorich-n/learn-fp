package learnfp.foldable

import learnfp.functor.Disjunction.{Disjunction, LeftDisjunction, RightDisjunction}
import learnfp.functor.Id
import learnfp.functor.Maybe.{Just, Maybe, Nothing}

trait Foldable[C[_]] {
  def foldr[A, B](xs: C[A])(init: B)(fx: (A, B) => B): B
}

object FoldableInstances {
  implicit def idFoldable: Foldable[Id] = new Foldable[Id] {
    override def foldr[A, B](xs: Id[A])(init: B)(fx: (A, B) => B): B = ???
  }

  implicit def listFoldable: Foldable[List] = new Foldable[List] {
    override def foldr[A, B](xs: List[A])(init: B)(fx: (A, B) => B): B = ???
  }

  implicit def tuple2Foldable: Foldable[({ type E[X] = (X, X) })#E] = new Foldable[({ type E[X] = (X, X) })#E] {
    override def foldr[A, B](xs: (A, A))(init: B)(fx: (A, B) => B): B = ???
  }

  implicit def tuple3Foldable: Foldable[({ type E[X] = (X, X, X) })#E] = new Foldable[({ type E[X] = (X, X, X) })#E] {
    override def foldr[A, B](xs: (A, A, A))(init: B)(fx: (A, B) => B): B = ???
  }

  implicit val maybeFoldable: Foldable[Maybe] = new Foldable[Maybe] {
    override def foldr[A, B](xs: Maybe[A])(init: B)(fx: (A, B) => B): B = ???
  }

  implicit def disjunctionFoldable[L]: Foldable[({ type E[X] = Disjunction[L, X] })#E] =
    new Foldable[({ type E[X] = Disjunction[L, X] })#E] {
      override def foldr[A, B](xs: Disjunction[L, A])(init: B)(fx: (A, B) => B): B = ???
    }
}

class FoldableOps[C[_], A](xs: C[A])(implicit foldable: Foldable[C]) {
  def myfoldr[B](init: B)(fx: (A, B) => B): B = foldable.foldr(xs)(init)(fx)
}

object FoldableOps {
  implicit def toFoldableOps[C[_], A](xs: C[A])(implicit foldable: Foldable[C]): FoldableOps[C, A] = new FoldableOps[C, A](xs)

  implicit def tuple2ToFoldableOps[A](xs: (A, A))(
      implicit foldable: Foldable[({ type E[X] = (X, X) })#E]): FoldableOps[({ type E[X] = (X, X) })#E, A] =
    new FoldableOps[({ type E[X] = (X, X) })#E, A](xs)

  implicit def tuple3ToFoldableOps[A](xs: (A, A, A))(
      implicit foldable: Foldable[({ type E[X] = (X, X, X) })#E]): FoldableOps[({ type E[X] = (X, X, X) })#E, A] =
    new FoldableOps[({ type E[X] = (X, X, X) })#E, A](xs)

  implicit def disjunctionToFoldableOps[L, A](xs: Disjunction[L, A])(
      implicit foldable: Foldable[({ type E[X] = Disjunction[L, X] })#E]): FoldableOps[({ type E[X] = Disjunction[L, X] })#E, A] =
    new FoldableOps[({ type E[X] = Disjunction[L, X] })#E, A](xs)
}
