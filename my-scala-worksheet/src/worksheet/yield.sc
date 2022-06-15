val sth1 = (for (c <- 'a' to 'e')
  yield for (n <- 0 to 3)
    yield c -> n).flatten

sth1.map(println)

val sth2 = ('a' to 'e').map {
  c => {
    (0 to 3).map {
      n => c -> n
    }
  }
}.flatten
sth2.map(println)

('a' -> 1).getClass
('a', 1).getClass

val m = Map('a' -> 1)
m.getClass
