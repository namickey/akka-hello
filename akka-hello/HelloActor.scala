import akka.actor.Actor

class HelloActor extends Actor{
  def receive = {
    case "Hello" => println("World")
    case "How are you?" => sender ! "I'm fine thank you!"
  }
}

