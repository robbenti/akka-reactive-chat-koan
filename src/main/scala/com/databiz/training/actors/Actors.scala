package com.databiz.training.actors

import akka.actor.{Props, ActorRef, ActorSystem}
import com.databiz.training.core.ChatService

trait ActorCore {

  implicit def system: ActorSystem

  // TODO: define the system shutdown hook
}
trait ProductionActorSystem extends ActorCore {

  // TODO: define the ActorSystem
  override val system: ActorSystem = 
    ActorSystem("reactive-chat")
}
trait TopLevelActors {
  this: ActorCore =>

  // TODO: declare the chatService actor
  val chatService: ActorRef = system.actorOf(
    Props(new ChatService), "chatService")

}
