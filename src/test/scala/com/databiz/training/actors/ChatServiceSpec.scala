/*package com.databiz.training.actors

import akka.testkit.{TestActorRef, EventFilter}
import com.databiz.training.core.ChatService
import com.databiz.training.core.ChatService.GetUsers

/**
 * Created by robbenti on 14/01/15.
 */
class ChatServiceSpec extends BaseSpec("akka-reactive-chat") {

  val username = "123test"

  "ChatService" should {
    "log the join messages correctly" in {
      val chatService = system.actorOf(ChatService.props)
      
      EventFilter.info(pattern = s".*$username.* joined.*", occurrences = 1) intercept {
        chatService ! ChatService.Join(username)
      }

      EventFilter.warning(pattern = s".*$username.* already joined.*", occurrences = 1) intercept {
        chatService ! ChatService.Join(username)
      }
    }

    "log the leave messages correctly" in {
      val chatService = system.actorOf(ChatService.props)
      
      EventFilter.warning(pattern = s".*$username.* didn't join.*", occurrences = 1) intercept {
        chatService ! ChatService.Leave(username)
      }

      chatService ! ChatService.Join(username)
      EventFilter.info(pattern = s".*$username.* left.*", occurrences = 1) intercept {
        chatService ! ChatService.Leave(username)
      }
    }
  }

}
*/