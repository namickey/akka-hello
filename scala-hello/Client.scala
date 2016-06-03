import scala.io.Source
import java.io.PrintWriter

object Client extends App {
  val hai = Set("01", "02")
  val src = Source.fromFile("a.csv")
  val fi = src.getLines.filter(line =>
    line.split(',').size > 4 && hai(line.split(',')(4))
  ).toList.sorted
  
  val out = new PrintWriter("b.txt")
  fi.foreach{line =>
    out.write(line + "\n")
    println(line)
  }
  println(fi.size)
  out.close
}

