package util


class Timer {

   private var duration = 0L
   private var started = false
   private var startedTime = 0L
   private var finishTime = 0L

   def start() {
      require(!started)
      startedTime = System.currentTimeMillis
      started = true
   }

   def stop() {
      require(started)
      finishTime = System.currentTimeMillis
      started = false
      require(finishTime > startedTime)
      duration = finishTime - startedTime
   }

   def getDuration = duration

   def isStarted = started

}
