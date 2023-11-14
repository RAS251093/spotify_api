package ras.spotify.model

import spray.json.DefaultJsonProtocol._
import spray.json.{JsValue, RootJsonFormat}

case class AlbumObj(
                     albumType: String,
                     totalTracks: Int,
                     availableMarkets: List[String],
                     externalUrls: ExtUrlsObj,
                     href: String,
                     spotifyId: String,
                     images: ImgObj,
                     name: String,
                     releaseDate: String,
                     releaseDatePrecision: String,
                     restrictions: Option[RestrictionReasonObj],
                     objType: String,
                     uri: String,
                     artists: List[ArtistObj]
                      )
object AlbumObj{
  implicit val jsonFormat: RootJsonFormat[AlbumObj] =
    new RootJsonFormat[AlbumObj] {
      override def read(json: JsValue): AlbumObj = {
        val fields = json.asJsObject().fields
        AlbumObj(
          albumType = fields.apply("album_type").convertTo[String],
          totalTracks = fields.apply("total_tracks").convertTo[Int],
          availableMarkets = fields.apply("available_markets").convertTo[List[String]],
          externalUrls = fields.apply("external_urls").convertTo[ExtUrlsObj],
          href = fields.apply("href").convertTo[String],
          spotifyId = fields.apply("id").convertTo[String],
          images = fields.apply("images").convertTo[ImgObj],
          name = fields.apply("name").convertTo[String],
          releaseDate = fields.apply("release_date").convertTo[String],
          releaseDatePrecision = fields.apply("release_date_precision").convertTo[String],
          restrictions = fields.get("restrictions").map(json => json.convertTo[RestrictionReasonObj]),
          objType = fields.apply("type").convertTo[String],
          uri = fields.apply("uri").convertTo[String],
          artists = fields.apply("artists").convertTo[List[ArtistObj]]
        )
      }

      override def write(obj: AlbumObj): JsValue = ???
    }
}