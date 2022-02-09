# Scala Interview Questions


## Scala Interview Questions - Basic

<details>

![](image/basic/scala_iwq_001.png)

![](image/basic/scala_iwq_002.png)

![](image/basic/scala_iwq_003.png)

Akka framework

Spark framework

Play framework

Scalding framework

Neo4j framework

![](image/basic/scala_iwq_004.png)

![](image/basic/scala_iwq_005.png)

![](image/basic/scala_iwq_006.png)

![](image/basic/scala_iwq_007.png)

![](image/basic/scala_iwq_008.png)

![](image/basic/scala_iwq_009.png)

![](image/basic/scala_iwq_010.png)


</details>

## Scala Interview Questions - Intermediate

<details>

![](image/intermediate/scala_iwq_001.png)

This one may be outdated now.

![](image/intermediate/scala_iwq_002.png)

![](image/intermediate/scala_iwq_003.png)

![](image/intermediate/scala_iwq_004.png)

![](image/intermediate/scala_iwq_005.png)

![](image/intermediate/scala_iwq_006.png)

This one is incorrect now.


![](image/intermediate/scala_iwq_007.png)

![](image/intermediate/scala_iwq_008.png)

![](image/intermediate/scala_iwq_009.png)

![](image/intermediate/scala_iwq_010.png)

![](image/intermediate/scala_iwq_011.png)

![](image/intermediate/scala_iwq_012.png)

![](image/intermediate/scala_iwq_013.png)

![](image/intermediate/scala_iwq_014.png)

![](image/intermediate/scala_iwq_015.png)

![](image/intermediate/scala_iwq_016.png)

![](image/intermediate/scala_iwq_017.png)

This one is incorrect.

def is the keyword to define a method.

A function is a callable unit of code that can take a single parameter, a list of parameters, or no parameters at all. A function can execute one or many statements and can return a value, a list of values, or no values at all.

![](image/intermediate/scala_iwq_018.png)

![](image/intermediate/scala_iwq_019.png)

![](image/intermediate/scala_iwq_020.png)

![](image/intermediate/scala_iwq_021.png)

This one is interesting.

![](image/intermediate/scala_iwq_022.png)

![](image/intermediate/scala_iwq_023.png)

![](image/intermediate/scala_iwq_024.png)

![](image/intermediate/scala_iwq_025.png)

![](image/intermediate/scala_iwq_026.png)

![](image/intermediate/scala_iwq_027.png)

![](image/intermediate/scala_iwq_028.png)

![](image/intermediate/scala_iwq_029.png)

</details>

## Scala Interview Questions - Advanced

<details>

![](image/advanced/scala_iwq_001.png)

![](image/advanced/scala_iwq_002.png)

![](image/advanced/scala_iwq_003.png)

![](image/advanced/scala_iwq_004.png)

![](image/advanced/scala_iwq_005.png)

![](image/advanced/scala_iwq_006.png)

![](image/advanced/scala_iwq_007.png)

</details>

## Fibonacci in Scala

<details>

5 ways to solve Fibonacci in Scala – Tail Recursion, Memoization, The Pisano Period & More

### Case 1: Pattern Matching


### Case 2: Loop


### Case 3: Tail Recursion


### Case 4: Lazy Evaluation with Scala Lazy List (replacing Streams) and Memoization

```dos
object fs {
  val fibLazy: LazyList[BigInt] = {
    def fs(prev: BigInt, curr: BigInt): LazyList[BigInt] = prev #:: fs(curr, prev + curr)
    fs(0, 1)
  }

  def main(args: Array[String]): Unit = {
    (100000 to 100010).foreach(n => println(s"The Fibonacci number of $n is: ${fibLazy(n)}"))
  }
}
```

### Case 5: The Pisano Period

```scala
def fib5( n : Int) : Int = {
  def fib_tail( n: Int, a: Int, b: Int): Int = n match {
    case 0 => a
    case _ => fib_tail(n - 1, b, (a + b) % 1000000)
  }
  return fib_tail( n % 1500000, 0, 1)
}
```
</details>


## Knowledge points for older version 

<details>


![](image/misc/01.png)

![](image/misc/02.png)

![](image/misc/03.png)

![](image/misc/04.png)

![](image/misc/05.png)

![](image/misc/06.png)

![](image/misc/07.png)

![](image/misc/08.png)

![](image/misc/09.png)

![](image/misc/10.png)

![](image/misc/11.png)

![](image/misc/12.png)

![](image/misc/13.png)

![](image/misc/14.png)

![](image/misc/15.png)

![](image/misc/16.png)

![](image/misc/17.png)

![](image/misc/18.png)

![](image/misc/19.png)

![](image/misc/20.png)

![](image/misc/21.png)

![](image/misc/22.png)

![](image/misc/23.png)

![](image/misc/24.png)

Scala provides three string interpolation methods out of the box: s, f and raw.

The f interpolator is typesafe.

If you try to pass a format string that only works for integers but pass a double, the compiler will issue an error.

In Scala, all processed string literals are simple code transformations. Anytime the compiler encounters a string literal of the form:

```
id"string content"
```

it transforms it into a method call (id) on an instance of StringContext.

</details>

