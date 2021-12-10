import scala.annotation.tailrec
import DataList.{EmptyList, NonEmptyList}

object ListOps {
  def foldOption[T](f: (T, T) => T): DataList[T] => Option[T] = {
    case NonEmptyList(head, tail) => foldOption(f)(tail) match {
      case Some(tail2) => Some(f(head, tail2))
      case _ => Some(head)
    }
    case EmptyList => None
  }


  def sum[T : Numeric](list: DataList[T]): T = {
    def sumT(a: T, b: T) = implicitly[Numeric[T]].plus(a, b)

    foldOption(sumT)(list) match {
      case Some(value) => value
      case None => Numeric[T].zero
    }
  }

  @tailrec
  def reverse[T](buffer: DataList[T])(l: DataList[T]): DataList[T] = {
    l match {
      case NonEmptyList(head, tail) => reverse(NonEmptyList(head, buffer))(tail)
      case EmptyList => buffer
    }
  }

  @tailrec
  private def filterImpl[T](f: T => Boolean)(buffer: DataList[T])(l: DataList[T]): DataList[T] = {
    l match {
      case NonEmptyList(head, tail) => if (f(head)) {
        filterImpl(f)(NonEmptyList(head, buffer))(tail)
      } else {
        filterImpl(f)(buffer)(tail)
      }
      case EmptyList => reverse(l)(buffer)
    }
  }

  final def filter[T](f: T => Boolean): DataList[T] => DataList[T] = filterImpl(f)(DataList.EmptyList)

  final def map[A, B](f: A => B): DataList[A] => DataList[B] = {
    case DataList.EmptyList => DataList.EmptyList
    case DataList.NonEmptyList(head, tail) => DataList.NonEmptyList(f(head), map(f)(tail))
  }

  def collect[A, B](f: PartialFunction[A, B]): DataList[A] => DataList[B] =
    filter(f.isDefinedAt).andThen(map(f))

}