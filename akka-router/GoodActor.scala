import akka.actor.Actor

class GoodActor extends Actor{
  def receive = {
    case "Hello" => 
        Thread.sleep(1000)
        println("Good")
    case "Good" =>
        Thread.sleep(2000)
        println("Bye")
  }
}
