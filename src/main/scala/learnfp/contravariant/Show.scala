package learnfp.contravariant

case class Show[A](show:A => String)

object Show {
  implicit val showContravariantFunctorInstance: ContravariantFunctor[Show] = new ContravariantFunctor[Show] {
    override def cmap[A, B](b: Show[B])(fx: A => B): Show[A] = ???
  }
}
