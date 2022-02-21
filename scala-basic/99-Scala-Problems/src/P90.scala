// P90 (**) Eight queens problem
//     This is a classical problem in computer science. The objective is to
//     place eight queens on a chessboard so that no two queens are attacking
//     each other; i.e., no two queens are in the same row, the same column, or
//     on the same diagonal.
//
//     Hint: Represent the positions of the queens as a list of numbers 1..N.
//     Example: List(4, 2, 7, 3, 6, 8, 5, 1) means that the queen in the first
//     column is in row 4, the queen in the second column is in row 2, etc.  Use
//     the generate-and-test paradigm.

object P90 {
  def main(args: Array[String]): Unit = {
    //eightQueens.map(x => println(x))
    /*
    List(4, 2, 7, 3, 6, 8, 1, 5)
    List(6, 3, 7, 2, 4, 8, 1, 5)
    List(3, 7, 2, 8, 6, 4, 1, 5)
    ...
     */
    var i = 1
    val l = List(1, 2, 3, 4, 5, 6, 7, 8)
    eightQueens.map(n => {
      print(s"Solution $i: ")
      n zip l map { case (x, y) => print(s"($x,$y) ") }
      println()
      i += 1
    })
    /*
    Solution 1: (4,1) (2,2) (7,3) (3,4) (6,5) (8,6) (1,7) (5,8)
    Solution 2: (6,1) (3,2) (7,3) (2,4) (4,5) (8,6) (1,7) (5,8)
    Solution 3: (3,1) (7,2) (2,3) (8,4) (6,5) (4,6) (1,7) (5,8)
    ...
     */
  }

  def eightQueens = {
    def validDiagonals(qs: List[Int], upper: Int, lower: Int): Boolean = qs match {
      case Nil => true
      case q :: tail => q != upper && q != lower && validDiagonals(tail, upper + 1, lower - 1)
    }

    def valid(qs: List[Int]): Boolean = qs match {
      case Nil => true
      case q :: tail => validDiagonals(tail, q + 1, q - 1)
    }

    def eightQueensR(curQueens: List[Int], remainingCols: Set[Int]): List[List[Int]] =
      if (!valid(curQueens)) Nil
      else if (remainingCols.isEmpty) List(curQueens)
      else remainingCols.toList.flatMap(c => eightQueensR(c :: curQueens, remainingCols - c))

    eightQueensR(Nil, Set() ++ (1 to 8))
  }
}
