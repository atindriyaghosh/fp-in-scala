package chapter3

import scala.runtime.ScalaRunTime.stringOf

/**
 * @author Atindriya
 */
object Exercise3 {
  sealed trait List[+A]
  case object Nil extends List[Nothing]
  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List {
    def drop[A](as: List[A], n: Int): List[A] = {
      if (n <= 1) as
      else
        as match {
          case Nil => Nil
          case Cons(_, xs) => drop(xs, n - 1)
        }
    }

    def apply[A](as: A*): List[A] =
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))
  }

  def formatResult[A](as: List[A], msg: String): String = {
    s"${msg} = ${stringOf(as)}"
  }

  def main(args: Array[String]): Unit = {
    val as = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(formatResult(as, "Original List"))
    println(formatResult(List.drop(as, 5), "List with 1st 5 elements removed"))
    println(formatResult(List.drop(List(), 5), "Empty List with 1st 5 elements removed"))
  }
}
