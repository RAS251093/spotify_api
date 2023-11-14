package ras.spotify.model

import spray.json.DefaultJsonProtocol._
import spray.json.{JsValue, RootJsonFormat}

case class ExtIdObj(isrc: Option[String], ean: Option[String], upc: Option[String])

object ExtIdObj{
  implicit val jsonFormat: RootJsonFormat[ExtIdObj] =
    new RootJsonFormat[ExtIdObj] {
      override def write(obj: ExtIdObj): JsValue = ???

      override def read(json: JsValue): ExtIdObj = {
        val fields = json.asJsObject().fields
        ExtIdObj(
          isrc = fields.get("isrc").map(json => json.convertTo[String]),
          ean = fields.get("ean").map(json => json.convertTo[String]),
          upc = fields.get("upc").map(json => json.convertTo[String])
        )
      }
    }
}


