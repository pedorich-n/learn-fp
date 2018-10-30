package learnfp.applicative

import learnfp.functor.Maybe.Maybe
import learnfp.functor.{MaybeInstance => MaybeFunctorInstance}

object MaybeInstance {
  import MaybeFunctorInstance._
  implicit val maybeApplicativeInstance: Applicative[Maybe] = new Applicative[Maybe] {
    override def pure[A](a: A): Maybe[A] = ???
    override def <*>[A, R](fx: Maybe[A => R])(a: Maybe[A]): Maybe[R] = ???
  }
}
