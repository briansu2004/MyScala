import scala.collection.mutable

class PriorityQueueTest{
  implicit val ord: Ordering[(Any,Int)] = Ordering.by(_._2)

  var queue = mutable.PriorityQueue[(Any,Int)]()

}

val pQueue = (new PriorityQueueTest())
val queue = pQueue.queue

queue.enqueue(("a",3))
queue.enqueue(("b",3))
queue.enqueue(("c",3))
queue.enqueue(("d",3))
queue.enqueue(("e",3))
println(queue)
//PriorityQueue((a,3), (b,3), (c,3), (d,3), (e,3))
queue.dequeue()
//res6: (Any, Int) = (a,3)
println(queue)
//PriorityQueue((e,3), (b,3), (c,3), (d,3))
queue.dequeue()
//res8: (Any, Int) = (e,3)
println(queue)
//PriorityQueue((d,3), (b,3), (c,3))