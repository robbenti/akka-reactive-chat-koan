package com.databiz.training.actors

/**
 * Created by robbenti on 14/01/15.
 */
class ActorsSpec extends BaseSpec("akka-reactive-chat") with ActorCore with TopLevelActors {

  "Actors" should {
    "be instantiable" in {
      system should not be null

      chatService should not be null
    }
  }
}
