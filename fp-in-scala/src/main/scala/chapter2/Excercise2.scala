package chapter2

import scala.annotation.tailrec

/**
 * @author Atindriya
 */
object Excercise2 {

  def isSorted[A](as: Array[A], comp: (A, A) => Boolean): Boolean = {
    @tailrec
    def go(i: Int): Boolean = {
      if (i == 0) true
      else if (comp(as(i - 1), as(i))) go(i - 1)
      else false
    }

    go(as.length - 1)
  }

  def main(args: Array[String]): Unit = {
    val array1 = Array(1, 3, 6, 13)
    val array2 = Array(4, 3, 2, 1)
    val array3 = Array(5, 7, 13, 2)
    println(isSorted(array1, (x: Int, y: Int) => y > x))
    println(isSorted(array2, (x: Int, y: Int) => y > x))
    println(isSorted(array3, (x: Int, y: Int) => y > x))
    println(isSorted(array1, (x: Int, y: Int) => y < x))
    println(isSorted(array2, (x: Int, y: Int) => y < x))
    println(isSorted(array3, (x: Int, y: Int) => y < x))
  }
}