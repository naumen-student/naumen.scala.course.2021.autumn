import java.util.regex.Pattern
import scala.util.Try
import scala.util.matching.Regex

object Exercises {
  trait Readable[T] {
    def read(string: String): Either[String, T]
  }

  implicit class Read(string: String) {
    def read[T](implicit reader: Readable[T]): Either[String, T] = reader.read(string)
  }

  object Read {
    def read[T](string: String)(implicit reader: Readable[T]): Either[String, T] = reader.read(string)
  }

  implicit def stringReader: Readable[String] = (string: String) => Right(string)

  implicit def intReader: Readable[Int] = (string: String) => Try(string.toInt).toEither.left.map(_ => "isn't int!")

  val pattern: Regex = "Some\\((.*)\\)".r

  implicit def optReader[T: Readable]: Readable[Option[T]] = {
    case "None" => Right(None)
    case pattern(x) => x.read[T].map(x => Some(x)).left.map(_ => "Bad type inside!")
    case _ => Left("it isn't Option!")
  }
}