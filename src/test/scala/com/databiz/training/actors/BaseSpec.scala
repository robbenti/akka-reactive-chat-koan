package com.databiz.training.actors

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{WordSpecLike, Matchers, BeforeAndAfterAll}

/**
 * Created by robbenti on 14/01/15.
 */
class BaseSpec(actorSystemName: String) extends TestKit(ActorSystem(s"$actorSystemName-test")) with ImplicitSender
with WordSpecLike with Matchers with BeforeAndAfterAll {

  override protected def afterAll(): Unit = {
    TestKit.shutdownActorSystem(system)
  }
}
