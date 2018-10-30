package learnfp.applicative

import learnfp.functor.State
import learnfp.functor.StateInstance._

object StateInstance {
  implicit def stateApplicativeInstance[S]: Applicative[({ type E[X] = State[S, X] })#E] =
    new Applicative[({ type E[X] = State[S, X] })#E] {
      override def pure[A](a: A): State[S, A] = ???
      override def <*>[A, R](fx: State[S, A => R])(a: State[S, A]): State[S, R] = ???
    }

  class StatePureApplicativeOps[A](a: A) {
    def pure[S]: State[S, A] = stateApplicativeInstance[S].pure(a)
  }

  implicit def stateToApplicativeOps[S, A, R](a: State[S, A => R]): FxApplicativeOps[A, R, State[S, _]] =
    new FxApplicativeOps[A, R, ({ type E[X] = State[S, X] })#E](a)
  implicit def stateToPureOps[A](a: A): StatePureApplicativeOps[A] = new StatePureApplicativeOps[A](a)
}
