

object Hi {

  implicit val n: Int = 5
  def add(x: Int)(implicit y: Int) = x + y

  def main(args: Array[String]) {
    println( add(5) ) 			// takes n from the current scope
    println( add(5) (1) )		//can always call explicitly
  }
}
