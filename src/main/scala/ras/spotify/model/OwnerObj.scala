package ras.spotify.model

import spray.json.DefaultJsonProtocol.StringJsonFormat
import spray.json.{JsValue, RootJsonFormat}

case class OwnerObj(
                   externalUrls: Option[ExtUrlsObj],
                   followers: Option[FollowersObj],
                   href: Option[String],
                   spotifyId: Option[String],
                   objType: Option[String],
                   uri: Option[String],
                   displayName: Option[String]
                   )

object OwnerObj{
  implicit val jsonFormat: RootJsonFormat[OwnerObj] =
    new RootJsonFormat[OwnerObj] {
      override def write(obj: OwnerObj): JsValue = ???

      override def read(json: JsValue): OwnerObj = {
        val fields = json.asJsObject().fields
        OwnerObj(
          externalUrls = fields.get("external_urls").map(json => json.convertTo[ExtUrlsObj]),
          followers = fields.get("followers").map(json => json.convertTo[FollowersObj]),
          href = fields.get("href").map(json => json.convertTo[String]),
          spotifyId = fields.get("id").map(json => json.convertTo[String]),
          objType = fields.get("type").map(json => json.convertTo[String]),
          uri = fields.get("uri").map(json => json.convertTo[String]),
          displayName = fields.get("display_name").map(json => json.convertTo[String])
        )
      }
    }
}
