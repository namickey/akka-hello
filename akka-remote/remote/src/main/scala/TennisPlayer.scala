import akka.actor._

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
