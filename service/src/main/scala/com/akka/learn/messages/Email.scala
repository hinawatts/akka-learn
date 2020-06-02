package com.akka.learn.messages

object Email {

  case class SendEmail(emailSendReq:String,customerId:String,clientId:String)

}
