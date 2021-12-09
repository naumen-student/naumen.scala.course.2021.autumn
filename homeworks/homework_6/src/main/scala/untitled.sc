import scala.language.higherKinds

case class HigherKB[T[_]] (
  value: T[Int]
                          )