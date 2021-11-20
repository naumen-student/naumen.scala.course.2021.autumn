import scala.language.higherKinds
import scala.util.matching.Regex
import scala.util.Try

object Exercises {

  trait Readable[T] {
    def read(v: String): Either[String, T]
  }

  implicit class Read(value: String) {
    def read[V: Readable]: Either[String, V] = implicitly[Readable[V]].read(value)
  }

  object Read {
    def read[V: Readable](s: String): Either[String, V] = implicitly[Readable[V]].read(s)
  }

  implicit val stringReadable: Readable[String] = s => Right(s)
  implicit val intReadable: Readable[Int] = i => Try(i.toInt).toEither.left.map(_ => i)

  val someRegex: Regex = "Some\\((.*)\\)".r

  implicit def optReadable[T: Readable]: Readable[Option[T]] = {
    case "None" => Right(None)
    case s @ someRegex(a) => implicitly[Readable[T]].read(a).map(Some(_)).left.map(_ => s)
    case s => Left(s)
  }
}
