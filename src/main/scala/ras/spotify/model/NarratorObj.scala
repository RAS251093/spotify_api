package ras.spotify.model

import spray.json.DefaultJsonProtocol.StringJsonFormat
import spray.json.{JsValue, RootJsonFormat}

case class NarratorObj(name: Option[String])

object NarratorObj{
  implicit val jsonFormat: RootJsonFormat[NarratorObj] =
    new RootJsonFormat[NarratorObj] {
      override def write(obj: NarratorObj): JsValue = ???

      override def read(json: JsValue): NarratorObj = {
        val fields = json.asJsObject().fields
        NarratorObj(
          name = fields.get("name").map(json => json.convertTo[String])
        )
      }
    }
}
