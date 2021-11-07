
trait Monad[F[_]] {

    def pure[A](a: A): F[A]

    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

    def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] = flatMap(fa)(item1 => flatMap(fb)(item2 => pure(f(item1, item2))))

    def sequence[A](fas: List[F[A]]): F[List[A]] = fas.map(a => flatMap(a)(item => pure(List(item)))).fold(pure(List[A]()))((a, b) => map2(a, b)(_++_))

    def compose[A, B, C](f: A => F[B])(g: B => F[C]): A => F[C] = item => flatMap(f(item))(g(_))
}

trait Functor[F[_]] {
    def map[A, B](a: F[A])(f: A => B): F[B]
}

object Functor {
    def functorFromMonad[F[_]](M: Monad[F]): Functor[F] = new Functor[F] {
        def map[A, B](a: F[A])(f: A => B): F[B] = M.flatMap(a)(item => M.pure(f(item)))
    }
}
