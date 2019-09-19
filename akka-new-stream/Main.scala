import akka.stream._
import akka.stream.scaladsl._
import akka.NotUsed
import akka.actor.ActorSystem
import akka.{ Done, NotUsed }
import akka.actor.ActorSystem
import akka.util.ByteString
import scala.concurrent._
import scala.concurrent.duration._
import java.nio.file.Paths

object Main extends App {
  implicit val system = ActorSystem("QuickStart")
  implicit val materializer = ActorMaterializer()
  val source: Source[Int, NotUsed] = Source(1 to 100)
  source.runForeach(i => println(i))(materializer)
  Await.result(system.terminate(), 2.seconds)
}
