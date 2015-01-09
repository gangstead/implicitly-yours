package gangstead

object ImplicitlyImplicit extends App {

  def basic() = {
    println("\nbasic")
    implicit val n: Int = 5

    //def add(x: Int)(implicit y: Int) = x + y
    def add(x: Int) = {
      x + implicitly[Int]
    }

    println(add(5))
  }

  /**
  * From discussion in the meetup, there is a slight difference between
  * using the implicit param and implicitly in the order of execution.
  * The implicit parameter is evaluated when the method is called so
  * if the implicit is a lazy val or a costly def the delay is incurred
  * before the implicit is actually used.
  */
  def cornerCase() = {
    println("\ncorner case")

    implicit def n = { println("a") ; 10}

    def add(x: Int) = {
      println("b")
      x + implicitly[Int]
    }

    def add2(x: Int)(implicit y: Int) = {
      println("b")
      x + y
    }

    println(add(5)) //b a 15
    println(add2(5))// a b 15
  }

  /**
  * If your function takes an implicit type the compiler can and will use a subtype
  * It is legal to have a type and subtype in scope, the compiler will use the subtype.
  * In this case we need a List[Any] and have List[Any], List[AnyVal] and List[Int] available.
  * The List[Int] is a subtype of the other two.  If a List[Double] were available we'd get a compiler
  * error because the compiler can't choose between the two.
  */
  def subtypes() = {
    println("\nsubtypes")
    //Most specific subtype whens
    def printList(implicit l: List[Any]) = l foreach println

    implicit val emptyList: List[Any] = Nil
    implicit val anyValList: List[AnyVal] = List(1,2.0)
    implicit val intyList: List[Int] = List(1, 2, 3)

    //implicit val doublyList: List[Double] = List(1.0,2.0,3.1) //ERROR. Double not a sub or parent type of Int.

    printList //1 2 3
  }

  def typeParams() = {
    println("\ntypeparams")
    //type parameters implicitly
    implicit def emptyList[T]: List[T] = Nil

    val x = implicitly[List[Int]] // x's type is List[Int], value is List()
    println(x)
  }

  /**
   * source: http://www.drmaciver.com/2008/03/an-introduction-to-implicit-arguments/
   * Advanced: Implicit def with an implicit parameter.
   */
  def doubleImplicit() = {
    println("\ndouble implicit")
    case class Foo[T](t: T)

    implicit val hello = "Hello"
    implicit def foo[T](implicit t: T) = Foo[T](t)

    println(implicitly[Foo[String]]) //From REPL: res1: Foo[String] = Foo(Hello)
  }

  basic()
  cornerCase()
  subtypes()
  typeParams()
  doubleImplicit()

}
