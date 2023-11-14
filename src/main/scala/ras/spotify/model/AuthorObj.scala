package ras.spotify.model

import spray.json.DefaultJsonProtocol.StringJsonFormat
import spray.json.{JsValue, RootJsonFormat}

case class AuthorObj(name: Option[String])

object AuthorObj{
  implicit val jsonFormat: RootJsonFormat[AuthorObj] =
    new RootJsonFormat[AuthorObj] {
      override def write(obj: AuthorObj): JsValue = ???

      override def read(json: JsValue): AuthorObj = {
        val fields = json.asJsObject().fields
        AuthorObj(
          name = fields.get("name").map(json => json.convertTo[String])
        )
      }
    }
}
