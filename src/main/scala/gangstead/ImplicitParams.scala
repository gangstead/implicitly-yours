package gangstead

class HiParam {

  implicit val n: Int = 5
  //implicit val no: Int = -1 //can only have one implicit type match!

  def add(x: Int)(implicit y: Int) = x + y

  def main(args: Array[String]) {
    println( add(5) ) 			// takes n from the current scope
    println( add(5) (1) )		//can always call explicitly
  }
}
