package ras.spotify.model

import spray.json.{JsValue, RootJsonFormat}
import spray.json.DefaultJsonProtocol._

case class TrackObj(
                     album: Option[AlbumObj],
                     artists: Option[ArtistObj],
                     availableMarkets: List[String],
                     discNum: Option[Int],
                     duration: Option[Int],
                     explicit: Option[Boolean],
                     externalId: Option[ExtIdObj],
                     externalUrls: Option[ExtUrlsObj],
                     href: Option[String],
                     id: Option[String],
                     isPlayable: Option[Boolean],
                     linkedFrom: Option[TrackObj],
                     restrictions: Option[RestrictionReasonObj],
                     name: Option[String],
                     popularity: Option[Int],
                     previewUrl: Option[String],
                     trackNum: Option[Int],
                     objType: Option[String],
                     uri: Option[String],
                     isLocal: Option[Boolean]
                   )

object TrackObj {
  implicit val jsonFormat: RootJsonFormat[TrackObj] =
    new RootJsonFormat[TrackObj] {
      override def read(json: JsValue): TrackObj = {
        val fields = json.asJsObject().fields
        TrackObj(
          album = fields.get("album").map(json => json.convertTo[AlbumObj]),
          artists = fields.get("artists").map(json => json.convertTo[ArtistObj]),
          availableMarkets = fields.get("available_markets").map(json => json.convertTo[List[String]]),
          discNum = fields.get("disc_number").map(json => json.convertTo[Int]),
          duration = fields.get("duration_ms").map(json => json.convertTo[Int]),
          explicit = fields.get("explicit").map(json => json.convertTo[Boolean]),
          externalId = fields.get("external_ids").map(json => json.convertTo[ExtIdObj]),
          externalUrls = fields.get("external_urls").map(json => json.convertTo[ExtUrlsObj]),
          href = fields.get("href").map(json => json.convertTo[String]),
          id = fields.get("id").map(json => json.convertTo[String]),
          isPlayable = fields.get("is_playable").map(json => json.convertTo[Boolean]),
          //not sure what best way to do the below is.
          linkedFrom = fields.get("linked_from").map(json => json.convertTo[TrackObj]),
          restrictions = fields.get("restrictions").map(json => json.convertTo[RestrictionReasonObj]),
          name = fields.get("name").map(json => json.convertTo[String]),
          popularity = fields.get("popularity").map(json => json.convertTo[Int]),
          previewUrl = fields.get("preview_url").map(json => json.convertTo[String]),
          trackNum = fields.get("track_number").map(json => json.convertTo[Int]),
          objType = fields.get("type").map(json => json.convertTo[String]),
          uri = fields.get("uri").map(json => json.convertTo[String]),
          isLocal = fields.get("is_local").map(json => json.convertTo[Boolean])
        )
      }

      override def write(obj: TrackObj): JsValue = ???
    }
}
