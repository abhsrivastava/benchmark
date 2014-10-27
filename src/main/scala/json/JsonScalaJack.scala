package json

import co.blocke.scalajack.ScalaJack
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}
import util.Timer

object JsonScalaJack {

   implicit val formats = Serialization.formats(NoTypeHints)
   val person = Person("Child", 28, true, List(ParentPerson("Parent", 57, true)), List(3000L,738434L), Some("blah"))
   val personList : List[Person] = (1 to 25000).foldLeft(List[Person]())((a,c) => a :+ person)

   def main(args: Array[String]) {


      val json4sToJSON = runJson4sToJSON
      val json4sToScala = runJson4sToScala
      val scalaJackToJSON = runScalaJackToJSON
      val scalaJackToScala = runScalaJackToScala
      val json4sToJSONList = runJson4sToJSONList
      val json4sToScalaList = runJson4sToScalaList
      val scalaJackToJSONList = runScalaJackToJSONList
      val scalaJackToScalaList = runScalaJackToScalaList

      show("------------Single Item-----------------")

      show("json4sToJSON: " + json4sToJSON)
      show("json4sToScala: " + json4sToScala)
      show("scalaJackToJSON: " + scalaJackToJSON)
      show("scalaJackToScala: " + scalaJackToScala)

      show("-------------Large List------------------")

      show("json4sToJSONList: " + json4sToJSONList)
      show("json4sToScalaList: " + json4sToScalaList)
      show("scalaJackToJSONList: " + scalaJackToJSONList)
      show("scalaJackToScalaList: " + scalaJackToScalaList)
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

   def runScalaJackToScalaList : Long = {
      val timer = new Timer()
      timer.start()
      val person : List[Person] = ScalaJack.read[List[Person]]("""[{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"}]""")
      timer.stop()
      timer.getDuration
   }

   def runScalaJackToJSONList : Long = {
      val timer = new Timer()
      timer.start()
      val json : String = ScalaJack.render[List[Person]](personList)
      timer.stop()
      timer.getDuration
   }

   def runJson4sToJSONList : Long = {
      val timer = new Timer()
      timer.start()
      val json = write(personList)
      timer.stop()
      timer.getDuration
   }

   def runJson4sToScalaList : Long = {
      val timer = new Timer()
      timer.start()
      val personList : List[Person] = read[List[Person]]("""[{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"},{"name":"Charles Hunt","age":28,"isLiving":true,"parents":[{"name":"Wendell Hunt","age":57,"isLiving":true}],"favoriteLongNumbers":[3000,738434],"optionalField":"blah"}]""")
      timer.stop()
      timer.getDuration
   }

   //todo: reusable timer method
   def go( f:() => String ): Long = {
      val timer = new Timer()
      timer.start()
      val result = f
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



