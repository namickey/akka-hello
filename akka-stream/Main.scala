import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.ClosedShape
import akka.stream.scaladsl._
import akka.util.Timeout

object Main extends App {
  implicit val system = ActorSystem("system")
  implicit val mat = ActorMaterializer()

  val source = Source(1 to 5)
  source.map(_*10).runForeach(println)
  
  Thread.sleep(2000)
  system.shutdown()
  
}
