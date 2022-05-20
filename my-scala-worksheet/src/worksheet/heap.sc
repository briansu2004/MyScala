val pq = collection.mutable.PriorityQueue(1, 2, 5, 3, 7)
println(pq)                  // elements probably not in order
println(pq.clone.dequeueAll) // prints ArraySeq(7, 5, 3, 2, 1)
