package chapter2

import scala.annotation.tailrec

/**
 * @author Atindriya
 */
object Excercise1 {
  
  
  // Terrible first attempt.
  def fib1(N: Int): Int = {
    @tailrec
    def go(i: Int, p1: Int, p2: Int): Int = {
      i match {
        case `N` => p1 + p2
        case _ => go(i + 1, p2, p1 + p2)
      }
    }

    N match {
      case 0 => 0
      case 1 => 1
      case _ => go(2, 0, 1)
    }
  }

  // Optimized.
  def fib2(n: Int): Int = {    
    @tailrec
    def go(n: Int, p1: Int, p2: Int): Int = {
      n match {
        case 0 => p1
        case _ => go(n - 1, p2, p1 + p2)
      }
    }

    go(n, 0, 1)
  }
    
  def formatResult(max: Int, f: (Int) => Int): String = {
    s"The ${max}th number in the Fibonacci series is ${f(max)}"
  }
  
  def main(args: Array[String]): Unit = {
    val n = 8
    println(formatResult(n, fib1))
    println(formatResult(n, fib2))
  }

}