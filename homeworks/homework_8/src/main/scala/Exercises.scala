import scala.util.matching.Regex
object Exercises {

  trait Read[T]{
    def read(str : String) : Either[String, T]
  }

  object Read{
    def read[T](str : String)
               (
                 implicit reader : Read[T]
               ) : Either[String, T] =
      reader.read(str)
  }

  implicit class ReadOps[T] (str : String) {
    def read[T](
                 implicit reader: Read[T]
               ) : Either[String, T] = {
      reader.read(str)
    }
  }

  implicit object StringRead extends Read[String] {
    def read(str : String) : Either[String, String] = Right(str)
  }

  implicit object IntRead extends Read[Int] {
    def read (str : String) : Either[String, Int] =
      {
        if (str forall Character.isDigit) Right(str.toInt)
            else Left("Can't parse this string!")
      }
  }

  val strPattern = new Regex("""Some\(([\S]+?)\)""")

  implicit def OptionRead[T : Read] : Read[Option[T]] = {
    case strPattern(value) => value.read [T] match {
      case Right(content) => Right(Some(content))
      case Left(_) => Left("Err while parsing")
    }
    case "None" => Right(None)
    case _ => Left("Error occurred")
  }
}
