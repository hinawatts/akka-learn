package com.akka.learn

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.http.scaladsl.Http
import com.akka.learn.service.EmailSendService

import scala.concurrent.ExecutionContextExecutor

object ESSMain extends App {

  implicit val system = ActorSystem("ESS-System");
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  val app = new ESSApp {

    override def actorSystem: ActorSystem = system

    override def emailSendService: ActorRef = actorSystem.actorOf(Props[EmailSendService])
  }

  Http().bindAndHandle(app.http.route, "0.0.0.0", 8080)
}
