package json

import co.blocke.scalajack._
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}
import util.Timer

object JsonScalaJack {

   implicit val formats = Serialization.formats(NoTypeHints)
   val person = Person("Child", 28, true, List(ParentPerson("Parent", 57, true)), List(3000L,738434L), Some("blah"))
   val personList : List[Person] = (1 to 25000).foldLeft(List[Person]())((a,c) => a :+ person)
   // create test data
   val sj = ScalaJack()
   val personStr = sj.render[Person](person)
   val personListStr = sj.render[List[Person]](personList)

   def main(args: Array[String]) {


      val scalaJackToScalaList =

      show("------------Single Item-----------------")

      show("json4sToJSON: " + runJson4sToJSON)
      show("json4sToScala: " + runJson4sToScala)
      show("scalaJackToJSON: " + runScalaJackToJSON)
      show("scalaJackToScala: " + runScalaJackToScala)

      show("-------------Large List------------------")

      show("json4sToJSONList: " + runJson4sToJSONList)
      show("json4sToScalaList: " + runJson4sToScalaList)
      show("scalaJackToJSONList: " + runScalaJackToJSONList)
      show("scalaJackToScalaList: " + runScalaJackToScalaList)
   }

   def show(show: String) = println(show)

   def runScalaJackToScala() : Long = {
      val sj = ScalaJack()
      val timer = new Timer()
      timer.start()
      val person : Person = sj.read[Person](personStr)
      timer.stop()
      timer.getDuration
   }

   def runScalaJackToJSON : Long = {
      val sj = ScalaJack()
      val timer = new Timer()
      timer.start()
      val json : String = sj.render[Person](person)
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
      val person = read[Person](personStr)
      timer.stop()
      timer.getDuration
   }

   def runScalaJackToScalaList : Long = {
      val sj = ScalaJack()
      val timer = new Timer()
      timer.start()
      val person : List[Person] = sj.read[List[Person]](personListStr)
      timer.stop()
      timer.getDuration
   }

   def runScalaJackToJSONList : Long = {
      val sj = ScalaJack()
      val timer = new Timer()
      timer.start()
      val json : String = sj.render[List[Person]](personList)
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
      val personList : List[Person] = read[List[Person]](personListStr)
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



