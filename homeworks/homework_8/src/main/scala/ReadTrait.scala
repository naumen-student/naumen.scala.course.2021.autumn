trait ReadTrait[T] {
  def read (str: String): Either[String, T]
}