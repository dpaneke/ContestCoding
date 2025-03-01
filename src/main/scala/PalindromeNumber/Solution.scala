package PalindromeNumber

object Solution {
  def isPalindrome(x: Int): Boolean = {
    val xStr: String = x.toString
    xStr == xStr.reverse
  }
}
