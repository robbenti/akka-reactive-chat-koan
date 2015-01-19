package com.databiz.training.api

import com.databiz.training.actors.{ActorCore, TopLevelActors}

/**
 * Created by robbenti on 02/11/14.
 */
trait API {
  this: TopLevelActors with ActorCore =>

  val routes = new UserAPI(chatService)(system.dispatcher).route

  val httpListener = system.actorOf(SprayHttpListener.props((routes)))
}
