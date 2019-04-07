import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import java.io._

object SimpleApp {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Word Count")
    val sc = new SparkContext(conf)
    var lines = sc.textFile("input.txt")
    var count = lines.map(line => line.split(" ").filter(word => word != "").length).reduce((acc, lineCount) => acc + lineCount)
    val writer = new PrintWriter(new File("result.txt" ))
    writer.write(count.toString())
    writer.close()
    sc.stop()
  }
}