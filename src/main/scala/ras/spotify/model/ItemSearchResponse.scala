package ras.spotify.model

import spray.json.{JsValue, RootJsonFormat}

case class ItemSearchResponse(
                               tracks: Option[Tracks],
                               artists: Option[Artists],
                               albums: Option[Albums],
                               playlists: Option[Playlists],
                               shows: Option[Shows],
                               episodes: Option[Episodes],
                               audiobooks: Option[Audiobooks]
                             )

object ItemSearchResponse {
  implicit val jsonFormat: RootJsonFormat[ItemSearchResponse] =
    new RootJsonFormat[ItemSearchResponse] {
      override def write(obj: ItemSearchResponse): JsValue = ???

      override def read(json: JsValue): ItemSearchResponse = {
        val fields = json.asJsObject().fields
        ItemSearchResponse(
          tracks = fields.get("tracks").map(json => json.convertTo[Tracks]),
          artists = fields.get("artists").map(json => json.convertTo[Artists]),
          albums = fields.get("albums").map(json => json.convertTo[Albums]),
          playlists = fields.get("playlists").map(json => json.convertTo[Playlists]),
          shows = fields.get("shows").map(json => json.convertTo[Shows]),
          episodes = fields.get("episodes").map(json => json.convertTo[Episodes]),
          audiobooks = fields.get("audiobooks").map(json => json.convertTo[Audiobooks])
        )
      }
    }
}