import scala.language.implicitConversions
import scala.util._
import scala.util.matching.Regex

object Read {
  val wrongInputToParse = "input is not support parse"
  // про Predef не до конца понял (
  //    почему то IntelliJ предлагает это под видом конвенции
  // )
  val regex: Regex = {
    Predef.augmentString("^Some\\((.*)\\)$").r
  }
  val illegalOption = "illegalOption"
  val unexpectedError = "unexpected error"

  def read[T] (str: String) (implicit read: ReadTrait[T]): Either[String, T] = {
    read.read(str)
  }

  implicit class ReadClass(str: String) {
    def read[T](implicit read: ReadTrait[T]): Either[String, T] = {
      read.read(str)
    }
  }

  implicit object strRead extends ReadTrait[String]  {
    override def read(str: String): Either[String, String] = {
       Right(str)
    }
  }

  implicit object intRead extends ReadTrait[Int] {
    override def read(str: String): Either[String, Int] = {
      val parseValue = Try(str.toInt)

      parseValue match {
        case Failure(_) => Left(wrongInputToParse)
        case Success(value) => Right(value)
      }
    }
  }

  implicit def optionRead[T : ReadTrait]: ReadTrait[Option[T]] = {
    case regex(value) => value.read[T] match {
      case Left(_) => Left(illegalOption)
      case Right(value) => Right(
        Some(value)
      )
    }
    case "None" => Right(None)
    case _ => Left(unexpectedError)
  }
}