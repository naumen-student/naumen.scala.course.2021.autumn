import scala.annotation.tailrec

object ListOps {

  /**
   * Функция fold "сворачивает" список из Т в один элемент типа Т.
   * Если в списке лишь один элемент, то он и вернётся, два - вернётся результат применения f к этим элементам,
   * больше двух - результат применения к f(f(f(...), a[i - 1]), a[i])
   * @param f функция свёртывания. Применяется попарно к предыдущему результату применения и i-ому элементу списка
   * @return None - если список пустой
   */
  def foldOption[T](f: (T, T) => T): DataList[T] => Option[T] = {

    @tailrec
    def foldOptionWithResult(
      f: (T, T) => T,
      list: DataList[T],
      result: Option[T]
    ): Option[T] = list match {
      case DataList.EmptyList => result
      case DataList.NonEmptyList(head, tail) => result match {
        case None => foldOptionWithResult(f, tail, Some(head))
        case Some(acc) => foldOptionWithResult(f, tail, Some(f(acc, head)))
      }
    }

    foldOptionWithResult(f, _, None)
  }

  /**
   * Используя foldOption[T](f: (T, T) => T) реализуйте суммирование всех элементов списка.
   * @return Если список пустой, то 0
   */
  def sum[T : Numeric](list: DataList[T]): T = {
    /**
     * Используйте для суммирования двух чисел любого типа (Int, Long, Double, Float etc)
     */
    def sumT(a: T, b: T) = implicitly[Numeric[T]].plus(a, b)

    foldOption(sumT)(list) match {
      case None => implicitly[Numeric[T]].zero
      case Some(listSum) => listSum
    }
  }

  // чтобы нерекурсивный фильтр не за квадрат, нужен ревёрс (если юзать только DataList)
  def reverse[T](l: DataList[T]): DataList[T] = {
    @tailrec
    def reverseWithResult(
      l: DataList[T],
      result: DataList[T]
    ): DataList[T] = l match {
      case DataList.EmptyList => result
      case DataList.NonEmptyList(head, tail) => reverseWithResult(tail, DataList.NonEmptyList(head, result))
    }

    reverseWithResult(l, DataList.EmptyList)
  }

  /**
   * Фильтрация списка. Хвостовая рекурсия
   * @param f - фильтрующее правило (если f(a[i]) == true, то элемент остаётся в списке)
   */
  @tailrec
  private def filterImpl[T](
    f: T => Boolean,
    buffer: DataList[T],
  )(
    l: DataList[T]
  ): DataList[T] = l match {
    case DataList.EmptyList => buffer
    case DataList.NonEmptyList(head, tail) => {
      if (f(head))
        filterImpl(f, DataList.NonEmptyList(head, buffer))(tail)
      else
        filterImpl(f, buffer)(tail)
    }
  }

  final def filter[T](f: T => Boolean): DataList[T] => DataList[T] = {
    filterImpl[T](f, DataList.EmptyList) _ andThen reverse[T]
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
    filter(f.isDefinedAt) andThen map(f)
  }
}