import akka.actor.{ActorSystem,Props}
import akka.pattern.ask
import akka.util.Timeout
import akka.actor.ActorRef
import scala.concurrent.duration._
import scala.util.{Success,Failure}
import scala.concurrent.ExecutionContext.Implicits.global
import akka.routing.{RoundRobinPool,RoundRobinGroup}

object Client extends App {
  val system = ActorSystem("system")
  val hello = system.actorOf(Props[HelloActor], "hello")
  val good = system.actorOf(Props[GoodActor], "good")
  println(hello.path.toString)
  val paths = List("/user/hello", "/user/good")
  //val actor = system.actorOf(RoundRobinPool(5).props(Props[HelloActor]), "router2")
  val actor = system.actorOf(RoundRobinGroup(paths).props(), "router2")
  //println(actor.self.path.toString())
  actor ! "Hello"
  actor ! "Hello"
  actor ! "Hello"
  actor ! "Hello"
  actor ! "Hello"
  actor ! "Hello"
  
  Thread.sleep(5000)
  system.shutdown()
  
}
