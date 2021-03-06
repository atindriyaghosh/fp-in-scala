package chapter2

/**
 * @author Atindriya
 */
object Exercise4 {
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    a: A => b: B => f(a, b)
  }
}