package ras.spotify.model

import spray.json.DefaultJsonProtocol.{IntJsonFormat, StringJsonFormat, listFormat}
import spray.json.{JsValue, RootJsonFormat}

case class Episodes(
                   href: String,
                   limit: Int,
                   next: Option[String],
                   offset: Int,
                   previous: Option[String],
                   total: Int,
                   items: List[SimpleEpisodeObj],
                   )
object Episodes{
  implicit val jsonFormat: RootJsonFormat[Episodes] =
    new RootJsonFormat[Episodes] {
      override def write(obj: Episodes): JsValue = ???

      override def read(json: JsValue): Episodes = {
        val fields = json.asJsObject().fields
        Episodes(
          href = fields.apply("href").convertTo[String],
          limit = fields.apply("limit").convertTo[Int],
          next = fields.get("next").map(json => json.convertTo[String]),
          offset = fields.apply("offset").convertTo[Int],
          previous = fields.get("previous").map(json => json.convertTo[String]),
          total = fields.apply("total").convertTo[Int],
          items = fields.apply("items").convertTo[List[SimpleEpisodeObj]]
        )
    }
  }
}
