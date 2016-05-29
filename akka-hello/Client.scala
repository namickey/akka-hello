import akka.actor.{ActorSystem,Props}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.util.{Success,Failure}
import scala.concurrent.ExecutionContext.Implicits.global

object Client extends App {
  val system = ActorSystem("system")
  val actor = system.actorOf(Props[HelloActor])
  actor ! "Hello"
  
  implicit val timeout = Timeout(5 seconds)
  val reply  = actor ? "How are you?"
  
  reply.onSuccess{
    case msg:String => println("reply from actor: " + msg)
  }
  
}
