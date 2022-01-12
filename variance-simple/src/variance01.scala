// Covariance
abstract class Animal {
  def name: String
}

// Contravariance
abstract class Printer[-A] {
  def print(value: A): Unit
}

// Invariance
class Container[A](value: A) {
  private var _value: A = value

  def getValue: A = _value

  def setValue(value: A): Unit = {
    _value = value
  }
}

case class Cat(name: String) extends Animal

case class Dog(name: String) extends Animal

class AnimalPrinter extends Printer[Animal] {
  def print(animal: Animal): Unit =
    println("The animal's name is: " + animal.name)
}

class CatPrinter extends Printer[Cat] {
  def print(cat: Cat): Unit =
    println("The cat's name is: " + cat.name)
}

object Contravariance01 {
  def main(args: Array[String]) {
    val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
    val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

    // prints: Whiskers, Tom
    printAnimalNames(cats)

    // prints: Fido, Rex
    printAnimalNames(dogs)

    val catPrinter: Printer[Cat] = new CatPrinter
    val animalPrinter: Printer[Animal] = new AnimalPrinter

    // pirnts: The cat's name is: Boots
    printMyCat(catPrinter, Cat("Boots"))

    // pirnts: The animal's name is: Boots
    printMyCat(animalPrinter, Cat("Boots"))


    /*
      The following code has compliation errors
      Type mismatch
     */
//    val catContainer: Container[Cat] = new Container(Cat("Felix"))
//    val animalContainer: Container[Animal] = catContainer
//    animalContainer.setValue(Dog("Spot"))
//    val cat: Cat = catContainer.getValue // Oops, we'd end up with a Dog assigned to a Cat
  }

  def printAnimalNames(animals: List[Animal]): Unit =
    animals.foreach {
      animal => println(animal.name)
    }

  def printMyCat(printer: Printer[Cat], cat: Cat): Unit =
    printer.print(cat)
}
