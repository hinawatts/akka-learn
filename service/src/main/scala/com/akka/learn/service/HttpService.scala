package com.akka.learn.service

import akka.http.scaladsl.server.Route
import com.akka.learn.ESSApp
import com.akka.learn.routes.EmailServiceRoutes

class HttpService(app: ESSApp) extends EmailServiceRoutes {

  lazy val route: Route = {
    emailServiceRoutes(app)
  }
}
