def multiply(x: Int)(implicit y: Int) = x * y

multiply(3)(10) // 30
multiply(4)(10) // 40

//multiply(3)
// error: could not find implicit value for parameter factor: Int

implicit val z: Int = 10

multiply(3) // 30
multiply(4) // 40

//implicit val z2: Int = 11

//multiply(3)
// error: ambiguous implicit values:
// both value y of type => Int
// and value z of type => Int
// match expected type Int


def alert(msg: String): Unit = println(msg)

//alert(7)
// error: type mismatch;
// found   : Int(7)
// required: String

implicit def intToString(i: Int): String = i.toString

alert(7)
// 7


//3.chat
// error: value chat is not a member of Int

class LoquaciousInt(x: Int) {
  def chat: Unit = for(i <- 1 to x) println("Hi!")
}

implicit def intToLoquaciousInt(x: Int) = new LoquaciousInt(x)

3.chat
// Hi!
// Hi!
// Hi!
