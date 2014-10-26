package json

import co.blocke.scalajack.ScalaJack
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}
import util.Timer

object JsonScalaJack {

   implicit val formats = Serialization.formats(NoTypeHints)
   val person = Person("Charles Hunt", 28, true, List(ParentPerson("Wendell Hunt", 57, true)), List(3000L,738434L), Some("blah"))

   def main(args: Array[String]) {
      val json4sToJSON = runJson4sToJSON
      val json4sToScala = runJson4sToScala
      val scalaJackToJSON = runScalaJackToJSON
      val scalaJackToScala = runScalaJackToScala

      show("json4sToJSON: " + json4sToJSON)
      show("json4sToScala: " + json4sToScala)
      show("scalaJackToJSON: " + scalaJackToJSON)
      show("scalaJackToScala: " + scalaJackToScala)
   }

   def show(show: String) = println(show)

   def runScalaJackToScala : Long = {
      val timer = new Timer()
      timer.start()
      val person : Person = ScalaJack.read[Person]("""{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"}""")
      timer.stop()
      timer.getDuration
   }

   def runScalaJackToJSON : Long = {
      val timer = new Timer()
      timer.start()
      val json : String = ScalaJack.render[Person](person)
      show(json)
      timer.stop()
      timer.getDuration
   }

   def runJson4sToJSON : Long = {
      val timer = new Timer()
      timer.start()
      val json = write(person)
      timer.stop()
      timer.getDuration
   }

   def runJson4sToScala : Long = {
      val timer = new Timer()
      timer.start()
      val person = read[Person]("""{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"}""")
      timer.stop()
      timer.getDuration
   }
}

case class Person(
   name: String,
   age: Int,
   isLiving: Boolean,
   parents: List[ParentPerson],
   favoriteLongNumbers: List[Long],
   optionalField: Option[String]
)

case class ParentPerson(
   name: String,
   age: Int,
   isLiving: Boolean
)



