package ras.spotify.model

import spray.json.DefaultJsonProtocol.StringJsonFormat
import spray.json.{JsValue, RootJsonFormat}

case class RestrictionReasonObj(reason: Option[String])

object RestrictionReasonObj{
  implicit val jsonFormat: RootJsonFormat[RestrictionReasonObj] =
    new RootJsonFormat[RestrictionReasonObj] {
      override def write(obj: RestrictionReasonObj): JsValue = ???

      override def read(json: JsValue): RestrictionReasonObj = {
        val fields = json.asJsObject().fields
        RestrictionReasonObj(
          reason = fields.get("reason").map(json => json.convertTo[String])
        )
      }
    }
}
