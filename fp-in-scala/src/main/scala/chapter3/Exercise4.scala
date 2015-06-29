package chapter3

/**
 * @author Atindriya
 */
object Exercise4 {

  sealed trait List[+A]
  case object Nil extends List[Nothing]
  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List {
    def dropWhile[A](as: List[A])(f: A => Boolean): List[A] = {
      as match {
        case Cons(x, xs) if f(x) => dropWhile(xs)(f)
        case _ => as
      }
    }

    def apply[A](as: A*): List[A] =
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))
  }

  def main(args: Array[String]): Unit = {
    val as = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(List.dropWhile(as)(x => x < 5))
  }

}