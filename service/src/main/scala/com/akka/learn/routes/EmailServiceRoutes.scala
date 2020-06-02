package com.akka.learn.routes

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives.{complete, get, onSuccess, path, _}
import akka.http.scaladsl.server.Route
import akka.util.Timeout
import com.akka.learn.ESSApp
import com.akka.learn.jsonSupport.JsonSupport
import com.akka.learn.messages.Email.SendEmail
import com.akka.learn.model.EmailSendResponse
import akka.pattern.ask
import scala.concurrent.duration._

trait EmailServiceRoutes extends JsonSupport {

  def emailServiceRoutes(app: ESSApp): Route = {

    implicit val system = app.actorSystem
    implicit val executionContext = system.dispatcher
    implicit val timeout = Timeout(20.seconds)

    path("sendEmail") {
      get {
        headerValueByName("x-customer-id"){(customerId)=>
          headerValueByName("x-client"){(client)=>
            onSuccess(app.emailSendService ? SendEmail("send email",customerId,client)) {
              case response: EmailSendResponse =>
                complete(StatusCodes.Accepted, response)
              case _ =>
                complete(StatusCodes.InternalServerError)
            }
          }

        }

      }
    }
  }

}

