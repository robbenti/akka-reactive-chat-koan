package com.databiz.training.web

import akka.io.IO
import com.databiz.training.actors.{ActorCore, TopLevelActors}
import com.databiz.training.api.API
import spray.can.Http

/**
 * Created by robbenti on 02/11/14.
 */
trait ReactiveChatServer {

  this: TopLevelActors with ActorCore with API =>

  IO(Http) ! Http.Bind(httpListener, interface = "localhost", port = 8080)

  sys.addShutdownHook {
    system.shutdown()
  }
}
