package chapter2

import scala.annotation.tailrec
import scala.runtime.ScalaRunTime._

/**
 * @author Atindriya
 */
object Exercise2 {

  def isSorted[A](as: Array[A], f: (A, A) => Boolean): Boolean = {
    @tailrec
    def go(i: Int): Boolean = {
      if (i == 0) true
      else if (f(as(i - 1), as(i))) go(i - 1)
      else false
    }

    go(as.length - 1)
  }

  def formatResult[A](as: Array[A], order: String, f: (A, A) => Boolean): String = {
    s"Is ${stringOf(as)} sorted in ${order} order? Answer: ${isSorted(as, f)}"
  }

  def main(args: Array[String]): Unit = {
    def gt(x: Int, y: Int): Boolean = y > x
    def lt(x: Int, y: Int): Boolean = y < x
    val array1 = Array(1, 3, 6, 13)
    val array2 = Array(4, 3, 2, 1)
    val array3 = Array(5, 7, 13, 2)
    println(formatResult(array1, "Ascending", gt))
    println(formatResult(array2, "Ascending", gt))
    println(formatResult(array3, "Ascending", gt))
    println(formatResult(array1, "Descending", lt))
    println(formatResult(array2, "Descending", lt))
    println(formatResult(array3, "Descending", lt))
  }

}