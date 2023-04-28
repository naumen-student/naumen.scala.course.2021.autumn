import scala.List.empty

trait Monad[F[T]] {

    def pure[A](x: A): F[A]

    def flatMap[A, B](fx: F[A])(f: A => F[B]): F[B]

    def map2[A, B, C](fx: F[A], fy: F[B])(f: (A, B) => C): F[C] = {
        flatMap(fx)(
            x => flatMap(fy)(
                y => pure(
                    f(x, y)
                )
            )
        )
    }

    def sequence[A](f: List[F[A]]): F[List[A]] = {
        f.foldRight(pure(empty[A]))(
            (res, value) => flatMap(res)(
                flattenVal => flatMap(value)(
                    list => pure(
                        flattenVal :: list
                    )
                )
            )
        )
    }

    def compose[A, B, C](f: A => F[B])(g: B => F[C]): A => F[C] = {
        A => flatMap(f(A))(
            B => g(B)
        )
    }
}

trait Functor[F[T]] {
    def map[A, B](x: F[A])(f: A => B): F[B]
}

object Functor {
    def functorFromMonad[F[T]](_Monad: Monad[F]): Functor[F] = new Functor[F] {
        def map[A, B](x: F[A])(f: A => B): F[B] = {
            _Monad.flatMap(x)(
                x => _Monad.pure(f(x))
            )
        }
    }
}
