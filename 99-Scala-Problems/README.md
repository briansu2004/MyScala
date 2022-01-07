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

## P48

P48 (\*\*) Truth tables for logical expressions (3).

Omitted for now.

???

## P49

The reflected binary code (RBC), also known just as reflected binary (RB) or Gray code after Frank Gray, is an ordering of the binary numeral system such that two successive values differ in only one bit (binary digit).

```
Decimal Binary Gray Decimal
of Gray
0 0000 0000 0
1 0001 0001 1
2 0010 0011 3
3 0011 0010 2
4 0100 0110 6
5 0101 0111 7
6 0110 0101 5
7 0111 0100 4
8 1000 1100 12
9 1001 1101 13
10 1010 1111 15
11 1011 1110 14
12 1100 1010 10
13 1101 1011 11
14 1110 1001 9
15 1111 1000 8
```

## P50

Need to come back for it.

Not done yet.

## ...
