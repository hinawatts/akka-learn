package com.akka.learn.jsonSupport

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.akka.learn.model.EmailSendResponse
import spray.json.DefaultJsonProtocol

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {

  //marshaller to convert object to JSON response where object has two fields, so we used jsonFormat2 method to marshal it
  implicit val emailSendResponseFormat = jsonFormat3(EmailSendResponse)


}
