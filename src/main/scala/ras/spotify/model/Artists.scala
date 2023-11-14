package ras.spotify.model

import spray.json.DefaultJsonProtocol.{IntJsonFormat, StringJsonFormat, listFormat}
import spray.json.{JsValue, RootJsonFormat}

case class Artists(
                  href: String,
                  limit: Int,
                  next: Option[String],
                  offset: Int,
                  previous: Option[String],
                  total: Int,
                  items: List[ArtistObj]
                  )

object Artists {
  implicit val jsonFormat: RootJsonFormat[Artists] =
    new RootJsonFormat[Artists] {
      override def write(obj: Artists): JsValue = ???

      override def read(json: JsValue): Artists = {
        val fields = json.asJsObject().fields
        Artists(
          href = fields.apply("href").convertTo[String],
          limit = fields.apply("limit").convertTo[Int],
          next = fields.get("next").map(json => json.convertTo[String]),
          offset = fields.apply("offset").convertTo[Int],
          previous = fields.get("previous").map(json => json.convertTo[String]),
          total = fields.apply("total").convertTo[Int],
          items = fields.apply("items").convertTo[List[ArtistObj]]
        )
      }
    }
}