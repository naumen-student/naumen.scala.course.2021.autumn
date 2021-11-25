object Exercises {
  trait Read[A] {
    def read(value: String): Either[String, A]
  }

  object Read {
    def read[A](value: String)(implicit reader: Read[A]): Either[String, A] = reader.read(value)
  }

  implicit class ReadOperations(value: String) {
    def read[A](implicit reader: Read[A]): Either[String, A] = reader.read(value)
  }

  implicit def StringRead: Read[String] = (value: String) => Right(value)

  implicit def IntRead: Read[Int] = (value: String) => {
    if (IsStringIntable(value)) {
      Right(value.toInt)
    } else {
      Left(value)
    }
  }

  def IsStringIntable(value: String) = value.forall(_.isDigit);

  implicit def OptionRead[A: Read]: Read[Option[A]] = {
    case value if IsStringContainsSome(value) && getSomesContent(value).read[A].isRight => Right(Some(getSomesContent(value).read[A].right.get))
    case "None" => Right(None)
    case _ => Left("")
  }

  def IsStringContainsSome(value: String) = value.startsWith("Some(") && value.endsWith(")");
  def getSomesContent(value: String) = value.substring("Some(".length, value.length-1)
}
