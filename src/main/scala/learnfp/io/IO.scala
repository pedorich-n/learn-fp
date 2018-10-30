package learnfp.io

import learnfp.applicative.Applicative
import learnfp.functor.Functor
import learnfp.monad.Monad

case class IO[R](run: () => R)

object IO {
  implicit val ioFunctorInstance: Functor[IO] = new Functor[IO] {
    override def fmap[A, B](a: IO[A])(fx: A => B): IO[B] = IO { () =>
      fx(a.run())
    }
  }

  implicit val ioApplicativeInstance: Applicative[IO] = new Applicative[IO] {
    override def pure[A](a: A): IO[A] = IO { () =>
      a
    }
    override def <*>[A, R](fx: IO[A => R])(a: IO[A]): IO[R] = IO { () =>
      fx.run()(a.run())
    }
  }

  implicit val ioMonadInstance: Monad[IO] = new Monad[IO] {
    override def pure[A](a: A): IO[A] = ioApplicativeInstance.pure(a)
    override def flatMap[A, B](a: IO[A])(fx: A => IO[B]): IO[B] = fx(a.run())
  }

  def runIO[R](io: IO[R]): R = io.run()
}
