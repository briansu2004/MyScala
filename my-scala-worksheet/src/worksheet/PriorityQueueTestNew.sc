import scala.collection.mutable

class PriorityQueueTest {
  implicit val ord: Ordering[(Any, Int)] = Ordering.by(_._2)

  var queue = mutable.PriorityQueue[(Any, Int)]()

  def inplaceDeque(number: Int): Seq[(Any, Int)] = {
    var res: Seq[(Any, Int)] = Seq()
    res = queue.take(number).toSeq
    queue = queue.drop(number)
    res
  }
}

val pQueue = (new PriorityQueueTest())
val queue = pQueue.queue

queue.enqueue(("a", 3))
queue.enqueue(("b", 3))
queue.enqueue(("c", 3))
queue.enqueue(("d", 3))
queue.enqueue(("e", 3))
println(pQueue.queue)
// PriorityQueue((a,3), (b,3), (c,3), (d,3), (e,3))
pQueue.inplaceDeque(1)
// Seq((a,3))
println(pQueue.queue)
// PriorityQueue((b,3), (c,3), (d,3), (e,3))