package com.databiz.training

import com.databiz.training.actors.{ProductionActorSystem, TopLevelActors}
import com.databiz.training.api.API
import com.databiz.training.web.ReactiveChatServer

/**
 * Created by robbenti on 02/11/14.
 */
object ReactiveChatServerApp extends App with ProductionActorSystem with TopLevelActors
with API with ReactiveChatServer
