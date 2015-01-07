package gangstead

//import scala.language.implicitConversions //or  compiler option: language:implicitConversions

case class Enthusiast(level: Int)

class HiConvert {

  implicit def toEnthusiast(i : Int) = Enthusiast(i)
  def takesAnEnthusiast(e : Enthusiast) = println(s"Received $e")
  
  val scalaHuman = Enthusiast(11)
  val randomHuman = 2 //an int
  
  println("Enthusiasm level: " + scalaHuman.level)
  println("Enthusiasm level: " + randomHuman.level)
  
  takesAnEnthusiast(scalaHuman)
  takesAnEnthusiast(randomHuman)
}


