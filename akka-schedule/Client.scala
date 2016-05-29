import akka.actor.{ActorSystem,Props}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.util.{Success,Failure}
import scala.concurrent.ExecutionContext.Implicits.global

object Client extends App {
  val system = ActorSystem("system")
  val actor = system.actorOf(Props[HelloActor])
  val cancellable = system.scheduler.schedule(0 seconds, 1  seconds, actor, "Hello")

  Thread.sleep(5500)
  cancellable.cancel()
  Thread.sleep(1000)
  system.shutdown
}
