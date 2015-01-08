package gangstead

//case class Enthusiast(level: Int)

case class Admirer(esteem: Int)

class BetterAdmirer(h : Admirer){
  def boosted = h.esteem + 1
}

object Helper1 {
  implicit def AdmirerHelper(h: Admirer) = new BetterAdmirer(h)
}

object Helper2 {
  implicit class BestAdmirer(h : Admirer) {
    def bested = h.esteem * 100
  }
}

object ImplicitClassUseCase extends App{
  import Helper1._
  import Helper2._

  val scalaHuman = Admirer(11)

  println("Esteem:  " + scalaHuman.esteem)
  println("Boosted: " + scalaHuman.boosted)
  println("Bested:  " + scalaHuman.bested)
}
