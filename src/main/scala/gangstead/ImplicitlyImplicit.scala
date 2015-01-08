package gangstead

object ImplicitlyImplicit extends App {

  def basic() = {
    implicit val n: Int = 5

    //def add(x: Int)(implicit y: Int) = x + y
    def add(x: Int) = {
      x + implicitly[Int]
    }

    println(add(5))
  }

  def subtypes() = {
    //Most specific subtype whens
    def printList(implicit l: List[Any]) = l foreach println

    implicit val emptyList: List[Any] = Nil
    implicit val intyList: List[Int] = List(1, 2, 3)

    printList //1 2 3
  }

  def typeParams() = {
    //type parameters implicitly
    implicit def emptyList[T]: List[T] = Nil

    val x = implicitly[List[Int]] // x's type is List[Int], value is List()
    println(x)
  }

  /**
   * source: http://www.drmaciver.com/2008/03/an-introduction-to-implicit-arguments/
   */
  def doubleImplicit() = {
    case class Foo[T](t: T)

    implicit val hello = "Hello"
    implicit def foo[T](implicit t: T) = Foo[T](t)

    println(implicitly[Foo[String]]) //From REPL: res1: Foo[String] = Foo(Hello)
  }

  basic()
  subtypes()
  typeParams()
  doubleImplicit()

}
