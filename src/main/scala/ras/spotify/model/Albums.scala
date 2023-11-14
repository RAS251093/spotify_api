package ras.spotify.model

import spray.json.DefaultJsonProtocol.{IntJsonFormat, StringJsonFormat, listFormat}
import spray.json.{JsValue, RootJsonFormat}

case class Albums(
                 href: String,
                 limit: Int,
                 next: Option[String],
                 offset: Int,
                 previous: Option[String],
                 total: Int,
                 items: List[AlbumObj]
                 )

object Albums {
  implicit val jsonFormat: RootJsonFormat[Albums] =
    new RootJsonFormat[Albums] {
      override def write(obj: Albums): JsValue = ???

      override def read(json: JsValue): Albums = {
        val fields = json.asJsObject().fields
        Albums(
          href = fields.apply("href").convertTo[String],
          limit = fields.apply("limit").convertTo[Int],
          next = fields.get("next").map(json => json.convertTo[String]),
          offset = fields.apply("offset").convertTo[Int],
          previous = fields.get("previous").map(json => json.convertTo[String]),
          total = fields.apply("total").convertTo[Int],
          items = fields.apply("items").convertTo[List[AlbumObj]]
        )
      }
    }
}