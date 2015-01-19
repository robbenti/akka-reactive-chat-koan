package com.databiz.training.core

import akka.actor.{ActorRef, Actor, ActorLogging, Props}
import com.databiz.training.core.ChatService._

/**
 * Created by robbenti on 09/01/15.
 */
class ChatService extends Actor with ActorLogging {

  private var users = Set.empty[String]

  override def receive: Receive = {

        case Join(username) =>
          if (!users(username)) {
            users += username
            log.info("{} joined the chat", username)
          }
          else log.warning(s"The user $username already joined the chat")
  }
}

object ChatService {

  def props = Props(new ChatService)

  sealed trait ChatServiceInProtocol

  case class Join(username: String) extends ChatServiceInProtocol

  case class Leave(username: String) extends ChatServiceInProtocol

  case object GetUsers extends ChatServiceInProtocol

  case class DeliverMessage(from: String, to: String, message: String) extends ChatServiceInProtocol

  sealed trait ChatServiceOutProtocol

  case class Users(users: Set[String]) extends ChatServiceOutProtocol

  case class Joined(username: String) extends ChatServiceOutProtocol

  case class Left(username: String) extends ChatServiceOutProtocol

  case class Error(description: String) extends ChatServiceOutProtocol

}