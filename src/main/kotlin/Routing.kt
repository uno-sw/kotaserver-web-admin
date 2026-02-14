package jp.unosw

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            val html = """
                |<!doctype html>
                |<html>
                |  <head>
                |    <meta charset="UTF-8">
                |    <meta name="viewport" content="width=device-width, initial-scale=1">
                |    <title>Hello World!</title>
                |  </head>
                |  <body>
                |    <h1>Hello, World!</h1>
                |  </body>
                |</html>""".trimMargin()

            call.respondText(html, ContentType.Text.Html)
        }
    }
}
