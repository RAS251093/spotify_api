package ras.spotify.model

import spray.json.DefaultJsonProtocol.{IntJsonFormat, StringJsonFormat, listFormat}
import spray.json.{JsValue, RootJsonFormat}

case class Playlists(
                    href: String,
                    limit: Int,
                    next: Option[String],
                    offset: Int,
                    previous: Option[String],
                    total: Int,
                    items: List[SimplePlaylistObj]
                  )

object Playlists {
  implicit val jsonFormat: RootJsonFormat[Playlists] =
    new RootJsonFormat[Playlists] {
      override def write(obj: Playlists): JsValue = ???

      override def read(json: JsValue): Playlists = {
        val fields = json.asJsObject().fields
        Playlists(
          href = fields.apply("href").convertTo[String],
          limit = fields.apply("limit").convertTo[Int],
          next = fields.get("next").map(json => json.convertTo[String]),
          offset = fields.apply("offset").convertTo[Int],
          previous = fields.get("previous").map(json => json.convertTo[String]),
          total = fields.apply("total").convertTo[Int],
          items = fields.apply("items").convertTo[List[SimplePlaylistObj]]
        )
      }
    }
}