// P06 (*) Find out whether a list is a palindrome.
//     Example:
//     scala> isPalindrome(List(1, 2, 3, 2, 1))
//     res0: Boolean = true

object P06 {
  // Built-in
  def isPalindrome[T](l: List[T]): Boolean = l == l.reverse

  // Simple recursive
  def isPalindromeRecursive[T](l: List[T]): Boolean = l == l.reverse

  def main(args: Array[String]): Unit = {
    println("Using the built-in function: ")
    var lst = List(1, 1, 2, 3, 5, 8)
    println(s"The $lst is Palindrome: ${isPalindrome(lst)}")
    lst = List(1, 2, 3, 5, 8, 5, 3, 2, 1)
    println(s"The $lst is Palindrome: ${isPalindrome(lst)}")

    println("Using the simple recursive: ")
    lst = List(1, 1, 2, 3, 5, 8)
    println(s"The $lst is Palindrome: ${isPalindromeRecursive(lst)}")
    lst = List(1, 2, 3, 5, 8, 5, 3, 2, 1)
    println(s"The $lst is Palindrome: ${isPalindromeRecursive(lst)}")
  }
}
