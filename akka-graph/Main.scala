import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.ClosedShape
import akka.stream.scaladsl._
import akka.util.Timeout

object Main extends App {
    Sample1.main()
    Sample2.main()
}

object Sample2{
  def main() = {
    implicit val system = ActorSystem("system")
    implicit val mat = ActorMaterializer()

    val g = RunnableGraph.fromGraph(GraphDSL.create(){ implicit builder =>
      import GraphDSL.Implicits._
      val source = Source(1 to 5)
      val flow = Flow[Int].map(_ * 3)
      val sink = Sink.foreach(println)
      source ~> flow ~> flow ~> sink
      ClosedShape
    })
    g.run()
  
    Thread.sleep(2000)
    system.shutdown()
  }
}


object Sample1{
  def main() = {
    implicit val system = ActorSystem("system")
    implicit val mat = ActorMaterializer()

    val g = RunnableGraph.fromGraph(GraphDSL.create(){ implicit builder =>
      import GraphDSL.Implicits._
      val source = Source(1 to 5)
      val flow = Flow[Int].map(_ * 2)
      val sink = Sink.foreach(println)
      source ~> flow ~> flow ~> sink
      ClosedShape
    })
    g.run()
  
    Thread.sleep(2000)
    system.shutdown()
  }
}
