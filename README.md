# MyScala

My Scala

## Scala 2 cheat sheet

https://docs.scala-lang.org/cheatsheets/index.html

## Coming soon

- 99 Scala Problems

- REST API with Akka HTTP

- Play framework for REST API

- ScalaTest for test

- ScalaMock for mock

- Scalafix for lint

- ? for Scala DevOps

  Buddy CI/CD?

- ? for Scala ?

## Variance : Covariance vs Contravariance vs Invariance

方差：协方差 vs 逆变 vs 不变

```scala
class Foo[+A] // A covariant class
class Bar[-A] // A contravariant class
class Baz[A]  // An invariant class
```

https://docs.scala-lang.org/tour/variances.html

![](image/README/variance_01.png)

![](image/README/variance_02.png)

Variance is the correlation of subtyping relationships of complex types and the subtyping relationships of their component types. Scala supports variance annotations of type parameters of generic classes, to allow them to be covariant, contravariant, or invariant if no annotations are used.

Generic classes in Scala are invariant by default.

## 2022-01-05 Zhi

https://github.com/zhiwilliam/couses

## 2022-01-12 Zhi

DSL

-A +B

C D

type class ?

```scala
val map: Map[String, List[Int]] = Map("a" -> List(1, 2, 3), "b" -> List(2, 3))
  // type class
  //println(map.partition(x => x._2.length > 2))
  map.partitionByValue(_ <= 2)
  // (Map("a"-> List(1,2), "b" -> List(2)), Map("a"-> List(3), "b" -> List(3)))
```

```scala
val map: Map[A, List[B]]
```

Use span!

Case class doesn't have methods, so no need to be extended by case classes.

Type class doesn't have inheritance.

Rabbits don't meow, bark or speak.

cio schema

foldLeft +

foldLeft - ==> foldLeft +(-)

## 2022-01-19 Zhi

cio project vs Spring

"<%" ducking type

Structural types

"Object" keyword in Scala : singleton (pattern)

It uses the least memory

![](image/README/Scala_collection_mutable.png)

![](image/README/Scala_collection_immutable.png)

Grouping all impilicit objects in implicits ==> easy to import \*.implicits.\_

Quill

Syntax sugar for implicit

Course2, test.scala -> check it out

try to find out the best mutual funds (best increasements)

map + flatmap + pure

flatmap is sequential, not in parallel

flatmap: A->F[B]

need to get the values!

need to create a new box, can't use the old box

need to use Future API

In Scala, flatMap() method is identical to the map() method, but the only difference is that in flatMap the inner grouping of an item is removed and a sequence is generated. It can be defined as a blend of map method and flatten method.

map: A->B

blackbox

doesn't need to get the values!

Applicative

How to do flatmap in parallel?

Use cats library or Future

try and future are eager only, others are lazy

Context bound

Java HashMap

HashMap issues and solutions in Java 7

HashMap issues and solutions in Java 8

Ppl from Citi capital market and RBC are generally better

Core Java interview

- cache friendly

- non-blocking

Big Data interview

- Garbage collection

## 2022-02-02 Zhi

- iw q: context bound, Monad, map, flatmap, Functor, ...
- cats, kitter
- fs2, http4s
- co.fs2
- Functor, Foldable, Applicative
- CO ? ZIO (resource management, multi-threading, ...)
- Use play (future) before CO
- hoccon === JSON
- tsec authentication
- how to async?
- how to DI?
- how to work with Kafka?
- Spring Boot uses annotation for Redis - this has cons
- Fail fast for cloud / k8s infrastructure
- Fail propogate to the parent layer in the cloud / distributed environment
- Use CATS, ZIO to do async
- cache friendly : CPU cache, L1/L2/L3, padding
- Scala pathways: Big Data / data processing / Spark & Streaming, REST API, DSL, ...
- fifo queue
- Use Scala to build a project for the job interview
- SQL iw: Lin Ping lao shi's SQL - google search
- Java iw: Hashmap vs Hashtable, Bean Factory, aspect, design pattern, ...

## 2022-02-04 1st Scala job from the agent

- BOA Java/Scala developer!
    from the buddy agent Collbera

- Pluralsight free weekend!
    - 7 Scala courses and certificates

## 2022-02-07 1st Scala job talk with agent



## Scala Worksheet and Compiling Server issue and solution

Worksheet is a good feature.

![](image/README/scala_worksheet_new.png)

However, it doesn't work with the JDK 17.

The issues are something like "Compiling Server has issues" blah blah blah ...

Changing JDK to 13 will solve this issue, even may have some warnings.

![](image/README/scala_worksheet_work.png)


## 2022-02-09 Zhi

Kleisli

Stream for big data process

Tagless Final pattern in Scala
https://www.baeldung.com/scala/tagless-final-pattern#:~:text=In%20this%20long%20article%2C%20we,is%20available%20over%20on%20GitHub.
https://github.com/Baeldung/scala-tutorials/tree/master/scala-core-fp

IO.pure <-> ZIO.success

Read Tagless Final before learning CATS

ZIO and CATS are similar

Stream:
FS2 stream
spark stream
akka stream
...

scala shapeless

CATS OptionT

Monad transformer is the most difficult part in Monad

OptionT, ConT, IorT ... T is for Transformer

范畴论! category theory

h after g

丘奇数 / 邱奇数

Church number

CATS Effect! not cats



The Bay, Scotia, Citi, Meilin, HSBC, Disney, CIBC (tiger), ...


Questions



### Code practice tips

map, flatmap, groupBy

type class

context bound: memorize it


### Job Search tips

Make a story (find a path: I choose REST API)

Update CV

Talk to Mr. Zhi

Update LinkedIn

Iws

Offers


### Homework

Make a list of future to a future of list


Answer:

```scala
import scala.concurrent.Future

object ListOfFuture2FutureOfList extends App {

  import scala.concurrent.ExecutionContext.Implicits.global

  val ListOfFuture = List(Future(1), Future(2), Future(3))
  val futureOfList = Future.sequence(ListOfFuture)
  println(futureOfList)
}
```

![](image/README/ListOfFuture2FutureOfList.png)

## 2022-02-10 BOA iw

REST API, microservices, Big Data, ZIO

3-yr contract

15 ppl team (2 BA, 1 PM, 7 dev, some offshore devs); the whole team is quite large 

## 2022-02-12 re-create sbt project

![](image/README/create_sbt_project_01.png)

![](image/README/create_sbt_project_02.png)


build.sbt

```dos
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "TradingAnalysis"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % "test"
```

Update sbt

## 2022-02-13

### Move files in IJ

Be careful to move files in IJ

Always use refactor to move, or you will break things.


### Scala: Any, AnyVal, AnyRef

Type Hierarchies in Scala

https://www.baeldung.com/scala/type-hierarchies#:~:text=2.2.-,AnyVal,are%20an%20abstract%20final%20type.


![](image/README/Scala_Any.png)


### Scala: Case class

Adding the case keyword causes the compiler to add a number of useful features automatically. The keyword suggests an association with case expressions in pattern matching.

First, the compiler automatically converts the constructor arguments into immutable fields (vals). The val keyword is optional. If you want mutable fields, use the var keyword. So, our constructor argument lists are now shorter.

Second, the compiler automatically implements equals, hashCode, and toString methods to the class, which use the fields specified as constructor arguments. So, we no longer need our own toString() methods.

Finally, also, the body of Person class becomes empty because there are no methods that we need to define!

### Scala: Type class

A type class is a pattern in programming originating in Haskell. It allows us to extend existing libraries with new functionality, without using traditional inheritance, and without altering the original library source code.

A type class is a group of types that satisfy a contract typically defined by a trait. They enable us to make a function more ad-hoc polymorphic without touching its code. This flexibility is the biggest win with the type-class pattern.

Type Classes in Scala

https://www.baeldung.com/scala/type-classes


### Scala: mkString

You can make use of the mkString( ) method to concatenate the resulting list 


### Scala: WorkSheet

WorkSheet is very helpful.


### Scala: Monad

Monads in Scala

https://www.baeldung.com/scala/monads


In Scala, Monads is a construction which performs successive calculations. It is an object which covers the other object. It is worth noting that here, the output of an operation at some step is an input to another computations, which is a parent to the recent step of the program stated. Monad is neither a class nor a trait, it is a concept. The maximum collections of the Scala are Monads but not all the Monads are collections, there are several Monads which are containers like Options in Scala. In short, we can say that in Scala the data types that implements map as well as flatMap() like Options, Lists, etc. are called as Monads.

Collections that support map as well as flatMap are called as monadic.



Other Collections

Besides List, there are a number of other collections in the Scala standard library. The most commonly used of these are Map, Set, Vector, and Stream. 

- Option
- List
- Map
- Set
- Vector
- Stream -> Lazy List



Why Vector?

Use of List is very common in Scala, but it can sometimes be inefficient for random access because the time complexity of accessing an element is O(n). Scala provides an alternative collection, Vector, that is optimized for random access by storing its elements in a tree structure that has little memory overhead. All operations on a Vector happen in effectively constant time, which means that for large collections it can be significantly more efficient than List.


A Stream is essentially a List with an undetermined number of elements, which are computed lazily. A “lazy” value is one that is only evaluated at the time it’s required.




### Scala: for-comprehension

for === flatMap

yield === map


A Comprehensive Guide to For-Comprehension in Scala

https://www.baeldung.com/scala/for-comprehension

In imperative programming languages, we use loops such as for-loop and while-loop to iterate over collections. The Scala programming language introduced a new kind of loop: the for-comprehension.


```scala
    val partyResultList = tradingDataList.groupBy(_.party).map {
      case (party, tradingList) =>
        val tradingVolume = tradingList.flatMap { rec =>
          rec.numShares.flatMap(shares => rec.tradePrice.map(price => price * BigDecimal(shares))).toList
        }.sum
        (party, tradingVolume)
    }.toList
```

==>

```scala
    val partyResultNewList = tradingDataList.groupBy(_.party).map {
      case (party, tradingList) =>
        val tradingVolume = {
          for {
            rec <- tradingList
            share <- rec.numShares
            price <- rec.tradePrice
          } yield BigDecimal(share) * price
      }.sum
      (party, tradingVolume)
    }.toList
```

Only Option, List, Vector ... are monad, String is not monad!

for === flatmap
yield === map

```scala
    val riskResultList = tradingDataList.groupBy(_.ticker).map {
      case (ticker, tradingList) =>
        val risk = tradingList.flatMap { rec =>
          rec.numShares.flatMap(shares => rec.tradePrice.map(price => price * BigDecimal(shares) * (if (rec.action.toLowerCase() == "buy") 1 else
            -1))).toList
        }.sum
        (ticker, risk)
    }.toList
```

==>

```scala
    val riskResultNewList = tradingDataList.groupBy(_.ticker).map {
      case (ticker, tradingList) =>
        val risk = {
          for {
            rec <- tradingList
            share <- rec.numShares
            price <- rec.tradePrice
          } yield BigDecimal(share) * price * (if (rec.action.toLowerCase == "buy") 1 else -1)
        }.sum
        (ticker, risk)
    }.toList
```

### Scala: ZIO Stream

ZStream
https://zio.dev/next/datatypes/stream/zstream/

ZIO Chunk is a wrapper on Java array.

Lots of good things in ZIO doc.

### Scala: Variance

Variance is the correlation of subtyping relationships of complex types and the subtyping relationships of their component types. Scala supports variance annotations of type parameters of generic classes, to allow them to be covariant, contravariant, or invariant if no annotations are used. The use of variance in the type system allows us to make intuitive connections between complex types, whereas the lack of variance can restrict the reuse of a class abstraction.

```scala
class Foo[+A] // A covariant class
class Bar[-A] // A contravariant class
class Baz[A]  // An invariant class
```

![](image/README/variance_example_01.png)

In this example, 

- A has to be the child type of C  (because of -A)
- B has to be the parent class of D (because of +B)

Type safe is the key!

The father of Scalar named his INC as TypeSafe

Why type safe?

Python is not type safe. Some issues happen only in runtime - can't be identitied in compile-time.



### Scala: CATS


Scala – Introduction to Cats
https://www.baeldung.com/scala/cats-intro

https://github.com/typelevel/cats

```scala
libraryDependencies += "org.typelevel" %% "cats-core" % "2.2.0"
```


A type class is a pattern in programming originating in Haskell. It allows us to extend existing libraries with new functionality, without using traditional inheritance, and without altering the original library source code. 

In Scala Cats, components of type classes can be specified as:

- Type class
- Instances of type class
- Interface objects
- Interface syntax

### Scala: Pure

What is pure in Scala?

A function is called pure function if it always returns the same result for same argument values and it has no side effects like modifying an argument (or global variable) or outputting something



Examples of pure functions

Given that definition of pure functions, as you might imagine, methods like these in the scala.math._ package are pure functions:

- abs
- ceil
- max
- min

These Scala String methods are also pure functions:

- isEmpty
- length
- substring


Examples of impure functions


- foreach

- Date and time related methods like getDayOfWeek, getHour, and getMinute are all impure because their output depends on something other than their input parameters. 



## 2022-02-14 BOA iw 2nd

The overall review is that your code is good! The end result (as discussed) is less important than the code quality.

We'll ask you a bunch of questions pertaining to Scala, Java and your experiences on different projects and such. Taking the lead on the interview will be my lead developers (Sean and Leo) – and there will be a behavioral interview section as well.

Failed!


## Scala: CATS

```dos
libraryDependencies += "org.typelevel" %% "cats-core" % "2.3.0"
```

```scala
import cats.implicits._

import scala.language.reflectiveCalls

val map1: scala.collection.immutable.Map[Int,List[String]] = Map(1 -> List(a), 2 -> List(b))
val map2: scala.collection.immutable.Map[Int,List[String]] = Map(1 -> List(c), 2 -> List(d))
val res0: scala.collection.immutable.Map[Int,List[String]] = Map(1 -> List(a, c), 2 -> List(b, d))
```

![](image/README/cats_01.png)






## Misc

### Self-cultivation


## ? Questions to StackOverflow

### Scala for-comprehension

Why this line doesn't work?

```scala
    val riskResultNewList = tradingDataList.groupBy(_.ticker).map {
      case (ticker, tradingList) =>
        val risk = tradingList.flatMap { rec =>
          for {
            inOut <- (if (rec.action.toLowerCase == "buy") 1 else -1)            // this line has error!
            share <- rec.numShares
            price <- rec.tradePrice
          } yield BigDecimal(share) * price //* (if (rec.action.toLowerCase == "buy") 1 else -1)
        }.sum
        (ticker, risk)
    }.toList
```


### Does Python have fo-comprehension?

### Does JavaScript have fo-comprehension?



## Questions to ask on Zhi's new class 2022-02-16 

- Why ZIO examples: 
    for { _ <- ... }

- What do ZIO projects look like?
    - ZIO + Kafka?

- What is the knowledge point for the Future List interview question?
    - sequence


##  2022-02-16 Zhi

BOA iw q

## 2022-02-17

BOA iw q V2

## 2022-02-18

- BOA iw q V3

- How to sum two Option[Int] in scala

    - Solution 1: CATS / monoid
  
```dos
import cats.implicits._

a |+| b
```

    - Solution 2: map and flatmap / for comprehension 


    - Soltion 3: reduceOption
    
    
    - Not a good solution: function

```dos
def addOptionInt(a: Option[Int], b: Option[Int]): Option[Int] = {
  (a, b) match {
    case(None, None) => None
    case(None, v@Some(_)) => v
    case(v@Some(_), None) => v
    case(Some(v1), Some(v2)) => Some(v1 + v2)
  }
}
```

    - Not a Soltion: getOrElse / orElse

```
a.getOrElse(0) + b.getOrElse(0)
```


    - Combination

```
import cats.implicits._

def addOptionInt(a: Option[Int], b: Option[Int]): Option[Int] = {
  (a, b) match {
    case (None, None) => None
    case (None, v@Some(_)) => v
    case (v@Some(_), None) => v
    case (Some(v1), Some(v2)) => Some(v1 + v2)
  }
}

def output(a: Option[Int], b: Option[Int]): Unit = {
  println(s"a: $a; b: $b")
  //println(s"for (x <- a; y <- b) yield x + y = ${for (x <- a; y <- b) yield x + y}")
  println(s"for (x <- a.orElse(Some(0)); y <- b.orElse(Some(0))) yield x + y = ${for (x <- a.orElse(Some(0)); y <- b.orElse(Some(0))) yield x + y}")
  println(s"a.flatMap(x => b.map(x + _)) = ${a.flatMap(x => b.map(x + _))}")
  println(s"(a ++ b).reduceOption(_ + _) = ${(a ++ b).reduceOption(_ + _)}")
  println(s"a |+| b = ${a |+| b}")
  println(s"addOptionInt(a,b) = ${addOptionInt(a, b)}")
  //println(s"a.getOrElse(0) + b.getOrElse(0) = ${a.getOrElse(0) + b.getOrElse(0)}")
}


var a: Option[Int] = None
var b: Option[Int] = None
output(a, b)

a = Some(1)
output(a, b)

b = Some(2)
output(a, b)

a = None
output(a, b)
```

![](image/README/option_int_add_solutions_01.png)

![](image/README/option_int_add_solutions_02.png)


Looks like 

a |+| b

and

(a ++ b).reduceOption(_ + _) 

are best answers.





## 2022-02-19

### reduceOption

When reducing a collection to a single value, prefer reduceOption to reduce.

ome collections are empty, using reduce may throw an exception.

`java.lang.UnsupportedOperationException: empty.reduceLeft`

reduceOption is a safer alternative, since it encodes the possibility of the empty list in its return type:

```dos
Seq(1, 2, 3).reduceOption(_ + _)
// res0: Option[Int] = Some(6)

Seq.empty[Int].reduceOption(_ + _)
// res1: Option[Int] = None
```

### Scalaz

Scalaz is a Scala library for functional programming.

```dos
libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.3.0-SNAPSHOT"
```

Scalaz provides additional modules for functionality beyond the basics included in scalaz-core

scalaz-effect: Effectful programs

```dos
libraryDependencies += "org.scalaz" %% "scalaz-effect" % "7.3.0-SNAPSHOT"
```

Community
- Gitter: Gitter
- IRC: Freenode
- Mailing List: Google Groups
- Voice Chat: Discord




