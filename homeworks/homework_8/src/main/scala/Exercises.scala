object Exercises {


  object Read {
    def read[T](value: String)(implicit readable: Readable[T]) = readable.read(value)
  }

  implicit class Read(s: String) {
    def read[T]()(implicit readable: Readable[T]): Either[String, T] = readable.read(s)
  }

  trait Readable[T] {
    def read(value: String): Either[String, T]
  }

  implicit val stringReadable: Readable[String] = (value: String) => Right(value)

  implicit val intReadable: Readable[Int] = (value: String) => stringToInt(value)

  def stringToInt(s: String): Either[String, Int] = try {
    Right(s.toInt)
  } catch {
    case e: Exception => Left("Error! Value is not a number!")
  }

  implicit def optionReadable[T: Readable]: Readable[Option[T]] = (value: String) => {
    if (value == "None") Right(None)
    else {
      val reg = """^Some\((.*)\)""".r
      value match {
        case reg(group) =>
          if (group.read[T].isRight)
            Right(Some(group.read[T].right.get))
          else
            Left(group.read[T].left.get)
        case _ => Left("Invalid argument error")
      }
    }
  }
}
