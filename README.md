# MyScala

My Scala

## Scala 2 cheat sheet

https://docs.scala-lang.org/cheatsheets/index.html

## Misc

## Coming soon

- 99 Scala Problems

- REST API with Akka HTTP

- Play framework for REST API

- ScalaTest for test

- ScalaMock for mock

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

## 20210112 Zhi

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
