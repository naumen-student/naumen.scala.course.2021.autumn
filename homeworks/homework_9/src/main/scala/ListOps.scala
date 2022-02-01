
import DataList.{EmptyList, NonEmptyList}

import scala.+:
import scala.annotation.tailrec

object ListOps {

  /**
   * Функция fold "сворачивает" список из Т в один элемент типа Т.
   * Если в списке лишь один элемент, то он и вернётся, два - вернётся результат применения f к этим элементам,
   * больше двух - результат применения к f(f(f(...), a[i - 1]), a[i])
   *
   * @param f функция свёртывания. Применяется попарно к предыдущему результату применения и i-ому элементу списка
   * @return None - если список пустой
   */
  //    @tailrec
  def foldOption[T](f: (T, T) => T): DataList[T] => Option[T] = {
    case EmptyList => None
    case NonEmptyList(head, tail) => foldOption(f)(tail) match {
      case Some(value) => Some(f(head, value))
      case None => Some(head)
    }
  }


  /**
   * Используя foldOption[T](f: (T, T) => T) реализуйте суммирование всех элементов списка.
   *
   * @return Если список пустой, то 0
   */
  def sum[T: Numeric](list: DataList[T]): T = {
    /**
     * Используйте для суммирования двух чисел любого типа (Int, Long, Double, Float etc)
     */
    def sumT(a: T, b: T) = implicitly[Numeric[T]].plus(a, b)

    foldOption(sumT)(list) match {
      case None => Numeric[T].zero
      case Some(value) => value
    }
  }

  /**
   * Фильтрация списка. Хвостовая рекурсия
   *
   * @param f - фильтрующее правило (если f(a[i]) == true, то элемент остаётся в списке)
   */
   @tailrec
  private def filterImpl[T](f: T => Boolean)(buffer: DataList[T])(l: DataList[T]): DataList[T] = l match {
    case EmptyList => buffer
    case NonEmptyList(head, tail) =>
      if (f(head)) filterImpl(f)(NonEmptyList(head, buffer))(tail)
      else filterImpl(f)(buffer)(tail)
  }

  final def filter[T](f: T => Boolean): DataList[T] => DataList[T] = {
    x => filterImpl[T](_ => true)(EmptyList)(filterImpl(f)(EmptyList)(x))
  }

  final def map[A, B](f: A => B): DataList[A] => DataList[B] = {
    case DataList.EmptyList => DataList.EmptyList
    case DataList.NonEmptyList(head, tail) => DataList.NonEmptyList(f(head), map(f)(tail))
  }

  /**
   * Используя композицию функций реализуйте collect. Collect - комбинация filter и map.
   * В качестве фильтрующего правила нужно использовать f.isDefinedAt
   */
  def collect[A, B](f: PartialFunction[A, B]): DataList[A] => DataList[B] = {
    l => map(f)(filter(x => f.isDefinedAt(x))(l))
  }
}