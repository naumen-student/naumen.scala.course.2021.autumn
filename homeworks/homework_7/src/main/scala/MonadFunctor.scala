
trait Monad[F[_]] {
    //можно сделать extends от Functor,
    //но раз тут такая сигнатура, сделаю так (просто чтобы не повторять код)
    private val functor = Functor.functorFromMonad(this)

    def pure[A](a: A): F[A]

    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

    def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] =
        flatMap(fa)(a =>
          functor.map(fb)(b => f(a,b))
        )

    def sequence[A](fas: List[F[A]]): F[List[A]] = {
        flatMap(
            fas.foldLeft(pure(List.empty[A]))(
                (acc, fa) =>
                    flatMap(acc)(lista =>
                        functor.map(fa)(a => a +: lista)
                    )
            )
        )(list => pure(list.reverse)) //можно растить лист в другую сторону, но тогда, кажется, сложность больше
    }

    def compose[A, B, C](f: A => F[B])(g: B => F[C]): A => F[C] =
        a => flatMap(f(a))(b => g(b))
}

trait Functor[F[_]] {
    def map[A, B](a: F[A])(f: A => B): F[B]
}

object Functor {
    def functorFromMonad[F[_]](M: Monad[F]): Functor[F] = new Functor[F] {
        def map[A, B](a: F[A])(f: A => B): F[B] =
            M.flatMap(a)(internalA => M.pure(f(internalA)))
    }
}
