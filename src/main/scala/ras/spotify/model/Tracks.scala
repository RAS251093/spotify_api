package ras.spotify.model

import spray.json.DefaultJsonProtocol.{IntJsonFormat, StringJsonFormat, listFormat}
import spray.json.{JsValue, RootJsonFormat}

case class Tracks(
                   href: String,
                   limit: Int,
                   next: Option[String],
                   offset: Int,
                   previous: Option[String],
                   total: Int,
                   items: List[TrackObj]
                 )

object Tracks {
  implicit val jsonFormat: RootJsonFormat[Tracks] =
    new RootJsonFormat[Tracks] {
      override def write(obj: Tracks): JsValue = ???

      override def read(json: JsValue): Tracks = {
        val fields = json.asJsObject().fields
        Tracks(
          href = fields.apply("href").convertTo[String],
          limit = fields.apply("limit").convertTo[Int],
          next = fields.get("next").map(json => json.convertTo[String]),
          offset = fields.apply("offset").convertTo[Int],
          previous = fields.get("previous").map(json => json.convertTo[String]),
          total = fields.apply("total").convertTo[Int],
          items = fields.apply("items").convertTo[List[TrackObj]]
        )
      }
    }
}