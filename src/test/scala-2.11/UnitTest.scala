/**
  * Created by sudhanshu on 06/12/15.
  */



import org.scalatest._

class UnitTest extends FlatSpec  {
  "A HTMLContentExtractor " should
    "return the contents of HTML page as string" in {

      val url: String = "http://www.bbc.co.uk/news/uk-35019021"
      val actual = new HtmlContentExtractor().content(url)//WebPageClassifier.textExtractor.(url)
//    val foo = actual.toString
//    val integ = 1
      assert(actual != null)

  }

  "A List(String Object) " should
    "return the words in the String as a List" in {
    val line = "Hello World".split(" +")
    assertResult("Hello")(line(0))
  }
}