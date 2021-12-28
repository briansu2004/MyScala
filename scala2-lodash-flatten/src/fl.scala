object fl {
  def main(args: Array[String]): Unit = {
    val lst = List(List(1, 1), List(3, List(5, 8)));

    println(lst);
    println(lst.flatten);
    println(lst.flatten.map(x => x + "hi"));
    //println(lst.flatMap(x => x.flatten(x => x:List)));
  }
}