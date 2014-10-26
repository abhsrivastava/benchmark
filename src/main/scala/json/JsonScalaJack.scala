package json

import co.blocke.scalajack.ScalaJack
import org.json4s._
import org.json4s.native.JsonMethods._

object JsonScalaJack {

   def main(args: Array[String]) {
      //todo go
   }

   def runScalaJackToScala = {
      //ScalaJack.read[Person]()
   }

   def runScalaJackToJSON = {
      //ScalaJack.render[Person]()
   }

   def runJson4sToJSON = {
      //compact(render(json))
   }

   def runJson4sToScala = {
      //parse()
   }

   case class Person(
      name: String,
      age: Int,
      isLiving: Boolean,
      parents: List[Person],
      favoriteLongNumbers: List[Long]
   )

}



