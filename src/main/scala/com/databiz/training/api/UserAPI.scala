package com.databiz.training.api

import akka.actor.ActorRef
import akka.util.Timeout
import com.databiz.training.core.ChatService
import spray.http.MediaTypes
import spray.json.{RootJsonFormat, DefaultJsonProtocol}
import spray.routing.Directives

import scala.concurrent.ExecutionContext

import akka.pattern.ask

import scala.concurrent.duration._

class UserAPI(chatService: ActorRef)(implicit executionContext: ExecutionContext)
  extends Directives {

  import spray.httpx.SprayJsonSupport._
  import JsonImplicits._

  implicit val timeout = Timeout(5 seconds)

  val route =
    pathPrefix("reactive-chat") {
      pathPrefix("users") {
        pathEnd {
          get {
            respondWithMediaType(MediaTypes.`application/json`) {
              complete {
                (chatService ? ChatService.GetUsers)
                  .mapTo[ChatService.Users]
                  .map(result => result.users.map(u => User(username = u)))
              }
            }
          }
        } ~ pathPrefix(Segment) {
          username =>
            path("join") {
              post {
                complete {
                  chatService ! ChatService.Join(username)
                  "post request has been sent"
                }
              }
            } ~ path("leave") {
              put {
                complete {
                  chatService ! ChatService.Leave(username)
                  "post request has been sent"
                }
              }
            } ~ path("deliver") {
              post {
                entity(as[Message]) {
                  message =>
                    complete {
                      chatService ! ChatService.DeliverMessage(from = username, to = message.to, message = message.message)
                      "post request has been sent"
                    }
                }
              }
            }
        }
      }
    }
}

case class Message(to: String, message: String)

case class User(username: String)

object JsonImplicits extends DefaultJsonProtocol {
  implicit val messageImpl: RootJsonFormat[Message] = jsonFormat2(Message)
  implicit val userImpl: RootJsonFormat[User] = jsonFormat1(User)
}
