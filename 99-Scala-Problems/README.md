# 99 Scala Problems

There are lots of questions.

## P09

If I run it like this, the red square button will stay there for a surprising long time.

```scala
    println("Using standard recursion: ")
    println(s"After packing the $lst: \n${pack(lst)}")
```

![](image/README/P09_01.png)

But if I run it like this (with some extra benchmarking code), then it will take much short time to stop.

```scala
    var start = LocalDateTime.now()
    println("Using standard recursion: ")
    println(s"After packing the $lst: \n${pack(lst)}")
    var end = LocalDateTime.now()
    var elapsed = Duration.between(start, end).toMillis
    println(s"Start:\t\t$start\nEnd:\t\t$end\nElapsed:\t$elapsed milliseconds")
```

![](image/README/P09_02.png)

Also, the elapsed time will be different for using the green triangle button on the top right, or using the similar one on the bottom left?

![](image/README/P09_03.png)

## P25

List to Array

### Issue

IDE compiler doesn't complain, but it has runtime error -

No ClassTag available for T

![](image/README/P25_01.png)

### Root cause

To instantiate an array in a generic context (instantiating an array of T where T is a type parameter), Scala needs to have information at runtime about T, in the form of an implicit value of type ClassTag[T].

### Solution

```
import scala.reflect.ClassTag
```

![](image/README/P25_02.png)

## P26, P27

Need to understand more on the solution!

@ can be used to bind a name to a successfully matched pattern, or subpattern.

## P28

The solution http://aperiodic.net/phil/scala/s-99/p28.scala is not compliable in IJ.
