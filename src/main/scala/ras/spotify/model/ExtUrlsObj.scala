package ras.spotify.model

import spray.json.DefaultJsonProtocol.StringJsonFormat
import spray.json.{JsValue, RootJsonFormat}

case class ExtUrls(spotifyUrl: Option[String])

object ExtUrls{
  implicit val jsonFormat: RootJsonFormat[ExtUrls] =
    new RootJsonFormat[ExtUrls] {
      override def write(obj: ExtUrls): JsValue = ???

      override def read(json: JsValue): ExtUrls = {
        val fields = json.asJsObject().fields
        ExtUrls(
          spotifyUrl = fields.get("spotify").map(json => json.convertTo[String])
        )
      }
    }
}
