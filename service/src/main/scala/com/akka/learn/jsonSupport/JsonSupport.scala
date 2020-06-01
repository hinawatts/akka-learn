package com.akka.learn.jsonSupport

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.akka.learn.model.EmailSendResponse
import spray.json.DefaultJsonProtocol

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {

  implicit val emailSendResponseFormat = jsonFormat1(EmailSendResponse)


}
