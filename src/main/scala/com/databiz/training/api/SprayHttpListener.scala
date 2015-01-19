package com.databiz.training.api

import akka.actor.{Props, ActorRefFactory, Actor}
import spray.routing._
import spray.util.LoggingContext

/**
 * Created by robbenti on 02/11/14.
 */
class ReactiveChatHttpService(route: Route) extends Actor with HttpService {

  override implicit def actorRefFactory: ActorRefFactory = context

  implicit private val routingSettings = RoutingSettings.default(actorRefFactory)

  override def receive: Receive = runRoute(route)(ExceptionHandler.default, RejectionHandler.Default, context,
    routingSettings, LoggingContext.fromActorRefFactory(actorRefFactory))
}

object SprayHttpListener {

  def props(route: Route) = Props(new ReactiveChatHttpService(route))

}
