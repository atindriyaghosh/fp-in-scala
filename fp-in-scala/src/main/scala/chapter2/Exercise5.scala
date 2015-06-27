package chapter2

/**
 * @author Atindriya
 */
object Exercise5 {
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }
}