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

object Court {
  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.load("application.conf")
    implicit val timeout: Timeout = Timeout(3000.milliseconds)
    implicit val system: ActorSystem = ActorSystem("Tennis", config)
    val playerA = system.actorOf(Props(classOf[TennisPlayer], "A", "a-!!"), "playerA")
    val playerB = system.actorOf(Props(classOf[TennisPlayer], "B", "un~~!"), "playerB")
    playerA ! GameStart(playerB)

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

case class TennisPlayer(name: String, howling: String) extends Actor {

  override def receive: Receive = {
    case Ball(vsPlayer) =>
      stroke(vsPlayer)
    case GameStart(vsPlayer) =>
      serve(vsPlayer)
  }

  def stroke(vsPlayer: ActorRef): Unit = {
    println(s"${name} < ${howling}!")
    Thread.sleep(1000)
    vsPlayer ! Ball(self)
  }

  def serve(vsPlayer: ActorRef): Unit = {
    println(s"${name} < serve!!!")
    vsPlayer ! Ball(self)
  }
}

case class Ball(player: ActorRef)

case class GameStart(vsPlayer: ActorRef)
