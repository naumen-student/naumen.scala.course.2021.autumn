import scala.util.Try
object Exercises {
  trait Read[T]{
    def read(str: String): Either[String, T]
  }

  object Read{
    def read[R: Read](str: String): Either[String, R] = implicitly[Read[R]].read(str)
  }

  implicit class ReadOps(str: String){
    def read[R: Read]: Either[String, R] = implicitly[Read[R]].read(str)
  }

  implicit val strRead: Read[String] = (str: String) => Right(str)

  implicit val intRead: Read[Int] = (str: String) => Try(str.toInt).toEither.left.map(_.getMessage)

  implicit def optRead[K: Read]: Read[Option[K]] = new Read[Option[K]] {
    private val someRegex = """Some\((.+?)\)""".r
    override def read(str: String): Either[String, Option[K]] =
      str match {
        case "None" => Right(None)
        case someRegex(value) => value.read[K].map(Some(_))
        case _ => Left(s"Read match error on string $str")
      }
  }
}
