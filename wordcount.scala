import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import java.io._

object SimpleApp {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Word Count")
    val sc = new SparkContext(conf)
    var lines = sc.textFile("input.txt")
    val wordMap = scala.collection.mutable.Map[String, Int]().withDefaultValue(0)
    sc.parallelize(lines.flatMap(_.split("\\W+")).collect.toList.groupBy(word => word).mapValues(value => value.length).toList, 1).saveAsTextFile("output")
  }
}