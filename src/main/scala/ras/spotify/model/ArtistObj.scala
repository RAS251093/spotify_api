package ras.spotify.model

import spray.json.DefaultJsonProtocol.{IntJsonFormat, StringJsonFormat, listFormat}
import spray.json.{JsValue, RootJsonFormat}

case class ArtistObj(
                      extUrls: Option[ExtUrlsObj],
                      followers: Option[FollowersObj],
                      genres: Option[List[String]],
                      href: Option[String],
                      id: Option[String],
                      images: Option[List[ImgObj]],
                      name: Option[String],
                      popularity: Option[Int],
                      objType: Option[String],
                      spotifyUri: Option[String]
                    )

object ArtistObj{
  implicit val jsonFormat: RootJsonFormat[ArtistObj] =
    new RootJsonFormat[ArtistObj] {
      override def write(obj: ArtistObj): JsValue = ???

      override def read(json: JsValue): ArtistObj = {
        val fields = json.asJsObject().fields
        ArtistObj(
          extUrls = fields.get("external_urls").map(json => json.convertTo[ExtUrlsObj]),
          followers = fields.get("followers").map(json => json.convertTo[FollowersObj]),
          genres = fields.get("genres").map(json => json.convertTo[List[String]]),
          href = fields.get("href").map(json => json.convertTo[String]),
          id = fields.get("id").map(json => json.convertTo[String]),
          images = fields.get("images").map(json => json.convertTo[List[ImgObj]]),
          name = fields.get("name").map(json => json.convertTo[String]),
          popularity = fields.get("popularity").map(json => json.convertTo[Int]),
          objType = fields.get("type").map(json => json.convertTo[String]),
          spotifyUri = fields.get("uri").map(json => json.convertTo[String])
        )
      }
    }
}
