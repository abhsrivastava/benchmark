
class Timer {

   private var duration = 0L
   private var started = false
   private var startedTime = 0L
   private var finishTime = 0L

   def start() {
      startedTime = System.currentTimeMillis
      started = true
   }

   def stop() {
      finishTime = System.currentTimeMillis
      started = false
      duration = finishTime - startedTime
   }

   def getDuration = duration

   def isStarted = started

}
