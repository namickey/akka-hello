import akka.stream._
import akka.stream.scaladsl._
import akka.NotUsed
import akka.actor._
import akka.{ Done, NotUsed }
import akka.actor.{ActorSystem, Props}
import akka.util.ByteString
import scala.concurrent._
import scala.concurrent.duration._
import java.nio.file.Paths
import akka.util.Timeout
import com.typesafe.config.ConfigFactory

object BCourt {
  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.load("application.conf")
    implicit val system: ActorSystem = ActorSystem("BTennis", config)

    while(true){
      println("press enter to exit.")
      val line = scala.io.StdIn.readLine
      if (line == ""){
        Await.result(system.terminate(), 1.seconds)
        return
      }
    }
  }
}
