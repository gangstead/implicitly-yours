package gangstead.akka

import akka.actor.Actor

class actorA extends Actor {
	def receive = {
		case Request =>
			Thread.sleep(300)
			println("actorA responds")
			sender ! 1
	}
}

class actorB extends Actor {
	def receive = {
		case Request =>
			Thread.sleep(600)
			println("actorB responds")
			sender ! "b"
	}
}

class actorC extends Actor {
	def receive = {
		case Request =>
			Thread.sleep(900)
			println("actorC responds")
			sender ! 3.0
	}
}

class actorD extends Actor {
	def receive = {
		case r: Result => println(s"ActorD received: $r")
	}
}
