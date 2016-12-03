package json

import co.blocke.scalajack._
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}
import util.Timer

object JsonBenchmark {
   implicit val formats = Serialization.formats(NoTypeHints)
   val person = Person("Child", 28, true, List(ParentPerson("Parent", 57, true)), List(3000L,738434L), Some("blah"))
   val personList : List[Person] = (1 to 25000).foldLeft(List[Person]())((a,c) => a :+ person)
   // create test data
   val sj = ScalaJack()
   val personStr = sj.render[Person](person)
   val personListStr = sj.render[List[Person]](personList)

   def main(args: Array[String]) {

      println("------------Single Item-----------------")

      println("json4s Write Json: " + runJson4sWriteJson)
      println("json4s Read Json: " + runJson4sReadJson)
      println("scalaJack Write Json: " + runScalaJackWriteJson)
      println("scalaJack Read Json: " + runScalaJackReadJson)
      println("Circe Write Json: " + runCirceWriteJson)
      println("Circe Read Json: " + runCirceReadJson)

      println("-------------Large List------------------")

      println("json4s Write JsonList: " + runJson4sWriteJsonList)
      println("json4s Read JsonList: " + runJson4sReadJsonList)
      println("scalaJack Write JsonList: " + runScalaJackWriteJsonList)
      println("scalaJack Read JsonList: " + runScalaJackReadJsonList)
      println("Circe Write JsonList: " + runCirceWriteJsonList)
      println("Circe Read JsonList: " + runCirceReadJsonList)
   }

   def runScalaJackReadJson() : Long = {
      val sj = ScalaJack()
      val timer = new Timer()
      timer.start()
      val person : Person = sj.read[Person](personStr)
      timer.stop()
      timer.getDuration
   }

   def runScalaJackWriteJson : Long = {
      val sj = ScalaJack()
      val timer = new Timer()
      timer.start()
      val json : String = sj.render[Person](person)
      timer.stop()
      timer.getDuration
   }

   def runJson4sWriteJson : Long = {
      val timer = new Timer()
      timer.start()
      val json = write(person)
      timer.stop()
      timer.getDuration
   }

   def runJson4sReadJson : Long = {
      val timer = new Timer()
      timer.start()
      val person = read[Person](personStr)
      timer.stop()
      timer.getDuration
   }

   def runScalaJackReadJsonList : Long = {
      val sj = ScalaJack()
      val timer = new Timer()
      timer.start()
      val person : List[Person] = sj.read[List[Person]](personListStr)
      timer.stop()
      timer.getDuration
   }

   def runScalaJackWriteJsonList : Long = {
      val sj = ScalaJack()
      val timer = new Timer()
      timer.start()
      val json : String = sj.render[List[Person]](personList)
      timer.stop()
      timer.getDuration
   }

   def runJson4sWriteJsonList : Long = {
      val timer = new Timer()
      timer.start()
      val json = write(personList)
      timer.stop()
      timer.getDuration
   }

   def runJson4sReadJsonList : Long = {
      val timer = new Timer()
      timer.start()
      val personList : List[Person] = read[List[Person]](personListStr)
      timer.stop()
      timer.getDuration
   }

   def runCirceWriteJson : Long = {
      import io.circe._, io.circe.generic.auto._, io.circe.syntax._
      val timer = new Timer()
      timer.start()
      val json = person.asJson
      timer.stop()
      timer.getDuration
   }

   def runCirceReadJson : Long = {
      import io.circe._, io.circe.generic.auto._, io.circe.parser.decode
      val timer = new Timer()
      timer.start()
      val person = decode[Person](personStr).right
      timer.stop()
      timer.getDuration
   }

   def runCirceWriteJsonList : Long = {
      import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
      val timer = new Timer()
      timer.start()
      val json = personList.asJson
      timer.stop()
      timer.getDuration
   }

   def runCirceReadJsonList : Long = {
      import io.circe._, io.circe.generic.auto._, io.circe.parser.decode
      val timer = new Timer()
      timer.start()
      val personList = decode[List[Person]](personListStr).right
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



