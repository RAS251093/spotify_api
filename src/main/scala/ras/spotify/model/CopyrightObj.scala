package ras.spotify.model

import spray.json.DefaultJsonProtocol.StringJsonFormat
import spray.json.{JsValue, RootJsonFormat}

case class CopyrightObj(
                       text: Option[String],
                       copyrightType: Option[String]
                       )
object CopyrightObj{
  implicit val jsonFormat: RootJsonFormat[CopyrightObj] =
    new RootJsonFormat[CopyrightObj] {
      override def write(obj: CopyrightObj): JsValue = ???

      override def read(json: JsValue): CopyrightObj = {
        val fields = json.asJsObject().fields
        CopyrightObj(
          text = fields.get("text").map(json => json.convertTo[String]),
          copyrightType = fields.get("type").map(json => json.convertTo[String])
        )
      }
    }
}
