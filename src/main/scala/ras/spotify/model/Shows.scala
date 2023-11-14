package ras.spotify.model

import spray.json.DefaultJsonProtocol.{IntJsonFormat, StringJsonFormat, listFormat}
import spray.json.{JsValue, RootJsonFormat}

case class Shows(
                href: String,
                limit: Int,
                next: Option[String],
                offset: Int,
                previous: Option[String],
                total: Int,
                items: List[SimpleShowObj]
                )
object Shows{
  implicit val jsonFormat: RootJsonFormat[Shows] =
    new RootJsonFormat[Shows] {
      override def write(obj: Shows): JsValue = ???

      override def read(json: JsValue): Shows = {
        val fields = json.asJsObject().fields
        Shows(
          href = fields.apply("href").convertTo[String],
          limit = fields.apply("limit").convertTo[Int],
          next = fields.get("next").map(json => json.convertTo[String]),
          offset = fields.apply("offset").convertTo[Int],
          previous = fields.get("previous").map(json => json.convertTo[String]),
          total = fields.apply("total").convertTo[Int],
          items = fields.apply("items").convertTo[List[SimpleShowObj]]
        )
      }
    }
}
