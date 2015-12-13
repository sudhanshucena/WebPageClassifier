import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.SparkContext
import scala.util.hashing.MurmurHash3
  /* Created by sudhanshu on 06/12/15.
  */
object WebPageClassifier {

  def main(args: Array[String]) {

    val HtmlExtractorObject = new HtmlContentExtractor()
    val conf = new SparkConf().setMaster("local").setAppName("Simple Application")
    val sc = new SparkContext(conf)


//    sc.setCheckpointDir("/tmp/spark/")
//    println("-------------Attach debugger now!--------------")
//    Thread.sleep(200)

    val readfile_one = sc.parallelize(HtmlExtractorObject.content("http://www.bbc.co.uk/news/uk-35023558").split(" +"),2)
    readfile_one.take(1).foreach(println)
    val stopwords = sc.textFile("file:///home/sudhanshu/Desktop/article_classificaiton/stopwords.txt").flatMap(line => line.split("\n"))
//    val readfile_two = sc.textFile("file:///home/sudhanshu/Desktop/article_classificaiton/file2")
//    readfile_two.take(2).foreach(println)
////    val readfile_three = sc.textFile("file:///home/sudhanshu/Desktop/article_classificaiton/index3.html")
////    val fileText = readfile_one.flatMap(line => line.split(" ")).filter(_.matches("[A-Za-z]+")).cache()
//    println("no. of words in file one "+fileText.count())
//    val notUnieuw = fileText.map(word=>(word,1)).reduceByKey((v1, v2)=> v1).map(_._1)
//    println("no. of unique words  "+notUnieuw.count())
////    stopwords.take(10).foreach(println)
//    val res = notUnieuw.subtract(stopwords)
//    println("no of results before hashing "+res.count())
//    val resAfterHash = res.map(word => (MurmurHash3.stringHash(word))).map(key=>(1,key))
//    println("no of results after hashing "+res.count())
//    resAfterHash.saveAsTextFile("file:///home/sudhanshu/Desktop/otp")

  }
}
