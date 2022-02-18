final case class Person1(firstName: String, lastName: String)

object PersonCanChat1 {
  def chat(x: Person1) = s"Hi, I'm ${x.firstName}"
}

PersonCanChat1.chat(Person1("John", "Smith"))

final case class Dog1(name: String)

object DogCanChat1 {
  def chat(x: Dog1) = s"Woof, my name is ${x.name}"
}

DogCanChat1.chat(Dog1("Meg"))

trait CanChat[A] {
  def chat(x: A): String
}

final case class Person(firstName: String, lastName: String)

object PersonCanChat extends CanChat[Person] {
  def chat(x: Person) = s"Hi, I'm ${x.firstName}"
}

final case class Dog(name: String)

object DogCanChat extends CanChat[Dog] {
  def chat(x: Dog) = s"Woof, my name is ${x.name}"
}
PersonCanChat.chat(Person("John", "Doe"))
DogCanChat.chat(Dog("Nick"))

object ChatUtil {
  def chat[A](x: A, chattyThing: CanChat[A]) = {
    chattyThing.chat(x)
  }
}

ChatUtilOld.chat(Dog("Meg"), DogCanChat)
ChatUtilOld.chat(Person("John", "Smith"), PersonCanChat)

object PersonCanChatFormally extends CanChat[Person] {
  def chat(x: Person) = s"Hello, I am ${x.firstName} ${x.lastName}"
}

ChatUtilOld.chat(Person("John", "Smith"), PersonCanChatFormally)



// ...in another package
//import ChattyAddons._

//ChatUtil.chat(Person("John", "Smith"))
//ChatUtil.chat(Dog("Meg"))

