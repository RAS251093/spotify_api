package ras.spotify.model

import spray.json.DefaultJsonProtocol.StringJsonFormat
import spray.json.{JsValue, RootJsonFormat}

case class RestrictionReason(reason: Option[String])

object RestrictionReason{
  implicit val jsonFormat: RootJsonFormat[RestrictionReason] =
    new RootJsonFormat[RestrictionReason] {
      override def write(obj: RestrictionReason): JsValue = ???

      override def read(json: JsValue): RestrictionReason = {
        val fields = json.asJsObject().fields
        RestrictionReason(
          reason = fields.get("reason").map(json => json.convertTo[String])
        )
      }
    }
}
