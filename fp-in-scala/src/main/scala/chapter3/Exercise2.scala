package chapter3

import scala.runtime.ScalaRunTime.stringOf
/**
 * @author Atindriya
 */
object Exercise2 {

  sealed trait List[+A]
  case object Nil extends List[Nothing]
  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List {
    def tail[A](as: List[A]): List[A] = {
      as match {
        case Nil => Nil
        case Cons(_, xs) => xs
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
    val as = List(1, 2, 3, 4, 5)
    println(formatResult(as, "Original List"))
    println(formatResult(List.tail(as), "List with 1st element removed"))
    println(formatResult(List(), "Empty List with 1st element removed"))
  }
}
