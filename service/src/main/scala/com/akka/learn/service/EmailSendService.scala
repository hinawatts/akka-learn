package com.akka.learn.service

import akka.actor.Actor
import com.akka.learn.messages.Email.SendEmail
import com.akka.learn.model.EmailSendResponse

class EmailSendService extends Actor {

  override def receive: Receive = {
    case SendEmail(emailSendReq,customerId,clientId) =>
      sender()!EmailSendResponse("Received request ",customerId,clientId)
  }
}
