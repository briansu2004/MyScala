import scala.collection.mutable
import scala.math.Ordering
// maxheap
val lowers = mutable.PriorityQueue[Int]()
// minheap
val highers = mutable.PriorityQueue[Int]()(Ordering[Int].reverse)

lowers.enqueue(12)
lowers.enqueue(8)
lowers.enqueue(22)
lowers.enqueue(11)
lowers.enqueue(3)
lowers.enqueue(200)
lowers

lowers.dequeue()
lowers.dequeue()
lowers.dequeue()
lowers.dequeue()
lowers.dequeue()
lowers.dequeue()

highers.enqueue(12)
highers.enqueue(8)
highers.enqueue(22)
highers.enqueue(11)
highers.enqueue(3)
highers.enqueue(200)
highers

highers.dequeue()
highers.dequeue()
highers.dequeue()
highers.dequeue()
highers.dequeue()
highers.dequeue()
