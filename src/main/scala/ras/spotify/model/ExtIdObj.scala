package ras.spotify.model

import spray.json.DefaultJsonProtocol._
import spray.json.{JsValue, RootJsonFormat}

case class ExternalIdObj(isrc: Option[String], ean: Option[String], upc: Option[String])

object ExternalIdObj{
  implicit val jsonFormat: RootJsonFormat[ExternalIdObj] =
    new RootJsonFormat[ExternalIdObj] {
      override def write(obj: ExternalIdObj): JsValue = ???

      override def read(json: JsValue): ExternalIdObj = {
        val fields = json.asJsObject().fields
        ExternalIdObj(
          isrc = fields.get("isrc").map(json => json.convertTo[String]),
          ean = fields.get("ean").map(json => json.convertTo[String]),
          upc = fields.get("upc").map(json => json.convertTo[String])
        )
      }
    }
}


