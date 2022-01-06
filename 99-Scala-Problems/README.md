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

## Where are P29 and P30?

## P31

Be careful of LazyList

Exception: "self-referential LazyList or a derivation thereof has no more elements"

Stream is deprecated

(Since version 2.13.0) Use LazyList (which is fully lazy) instead of Stream (which has a lazy tail only)

#:: is the cons operator for Streams / LazyLists.

In other words, #:: is to streams / LazyLists and :: is to Lists.

```
x #:: xs
```

===>

```
Stream.cons(x, xs)
```

## P36

Map

Additions and updates +, ++, updated, which let you add new bindings to a map or change existing bindings.

List.make(v.\_2, v.\_1)

==>

(v.\_1, v.\_2)

Looks like List.make is a very old method?

## Where are P42, P43, P44 and P45?

## P46

How to get the function name in Scala?

## William Zhi 2021-01-05

Scala case class vs Java record class

mapPar(2)(...)

A => B

Container?

Scala interview:

- Spark

- ?

Scala Stream vs Java Streaming API

Monad?

    - flatMap
    - tailrecM
    - pure

map can be implemented with flatMap

Option

Scala Option vs Java Option

Scala Quill

## ...
