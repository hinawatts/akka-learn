package com.akka.learn

import akka.actor.{ActorRef, ActorSystem}
import com.akka.learn.service.HttpService

abstract class ESSApp {

  def actorSystem: ActorSystem
  def emailSendService:ActorRef

  val http = new HttpService(this)
}
