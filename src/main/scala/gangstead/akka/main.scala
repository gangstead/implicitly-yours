package gangstead.akka

import akka.pattern.{ ask, pipe }
import akka.actor.ActorSystem
import akka.actor.Props
import akka.util.Timeout
import scala.concurrent.ExecutionContext.Implicits.global  //instead of system.dispatcher from the sample code
import scala.concurrent.duration._ //For the timeout duratino "5 seconds"
import scala.concurrent.Future  //For the `mapTo` function
import scala.language.postfixOps //removes warning on postfix ops like "5 seconds"

final case class Result(x: Int, s: String, d: Double)
case object Request

object main extends App {
	//Create the actors
	val system = ActorSystem("akka-actor-demo")
	val actorA = system.actorOf(Props[actorA], "actorA")
	val actorB = system.actorOf(Props[actorB], "actorB")
	val actorC = system.actorOf(Props[actorC], "actorC")
	val actorD = system.actorOf(Props[actorD], "actorD")

	implicit val timeout = Timeout(5 seconds) // needed for `?` below
  //implicit val timeout = 5 seconds //will not work, compiler will not blindly do all possible conversions to everything in scope to match a implicit param

	val f: Future[Result] =
		for {
			x <- ask(actorA, Request).mapTo[Int] // call pattern directly
			s <- (actorB ask Request).mapTo[String] // call by implicit conversion
			d <- (actorC ? Request).mapTo[Double] // call by symbolic name
		} yield Result(x, s, d)
    
    //other valid forms
    //actorRef does not contain an ask method: https://github.com/akka/akka/blob/master/akka-actor/src/main/scala/akka/actor/ActorRef.scala
    ask(actorA,Request)(timeout) 
    ask(actorA,Request)
    actorA.ask(Request) //actorRef is Bedazzled with ask pattern
    //https://github.com/akka/akka/blob/master/akka-actor/src/main/scala/akka/pattern/AskSupport.scala#L46
    actorA.ask(Request)(timeout)
    actorA.ask(Request)(5 seconds) //implicit conversion to Timeout
    //https://github.com/akka/akka/blob/master/akka-actor/src/main/scala/akka/util/Timeout.scala#L37
    actorA ask Request
    

	f pipeTo actorD // .. or ..
	//pipe(f) to actorD
	println("End of main execution")
}
