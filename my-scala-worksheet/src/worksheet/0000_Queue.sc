import scala.collection.immutable.Queue

println("Step 1: How to initialize a Queue with 3 elements")
val queue1: Queue[String] = Queue("Plain Donut", "Strawberry Donut", "Chocolate Donut")
println(s"Elements of queue1 = $queue1")

println("\nStep 2: How to access elements at specific index in a Queue")
println(s"Element at index 0 = ${queue1(0)}")
println(s"Element at index 1 = ${queue1(1)}")
println(s"Element at index 2 = ${queue1(2)}")

queue1