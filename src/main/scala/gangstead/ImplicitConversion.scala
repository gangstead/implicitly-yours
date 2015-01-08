package gangstead

//import scala.language.implicitConversions //or  compiler option: language:implicitConversions

case class Enthusiast(level: Int)

class ImplicitConversionUseCase {

  implicit def toEnthusiast(i : Int) = Enthusiast(i)
  //implicit def toVeryEnthusiast(i : Int) = Enthusiast(i*10) //this would be ambiguous

  def takesAnEnthusiast(e : Enthusiast) = s"Received $e"

  val scalaHuman = Enthusiast(11)
  val randomHuman = 2 //an int

  println("Enthusiasm level: " + scalaHuman.level)
  println("Enthusiasm level: " + randomHuman.level)

  println(takesAnEnthusiast(scalaHuman))
  println(takesAnEnthusiast(randomHuman))
}
