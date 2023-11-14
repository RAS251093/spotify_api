package ras.spotify.model

import spray.json.DefaultJsonProtocol.{BooleanJsonFormat, StringJsonFormat}
import spray.json.{JsValue, RootJsonFormat}

case class SimplePlaylistObj(
                            collaborative: Option[Boolean],
                            description: Option[String],
                            extUrls: Option[ExtUrlsObj],
                            href: Option[String],
                            id: Option[String],
                            images: Option[ImgObj],
                            name: Option[String],
                            owner: Option[OwnerObj],
                            public: Option[Boolean],
                            snapshotId: Option[String],
                            tracks: Option[TracksObj],
                            objType: Option[String],
                            uri: Option[String]
                            )
object SimplePlaylistObj{
  implicit val jsonFormat: RootJsonFormat[SimplePlaylistObj] =
    new RootJsonFormat[SimplePlaylistObj] {
      override def write(obj: SimplePlaylistObj): JsValue = ???

      override def read(json: JsValue): SimplePlaylistObj = {
        val fields = json.asJsObject().fields
        SimplePlaylistObj(
          collaborative = fields.get("collaborative").map(json => json.convertTo[Boolean]),
          description = fields.get("description").map(json => json.convertTo[String]),
          extUrls = fields.get("external_Urls").map(json => json.convertTo[ExtUrlsObj]),
          href = fields.get("href").map(json => json.convertTo[String]),
          id = fields.get("id").map(json => json.convertTo[String]),
          images = fields.get("images").map(json => json.convertTo[ImgObj]),
          name = fields.get("name").map(json => json.convertTo[String]),
          owner = fields.get("owner").map(json => json.convertTo[OwnerObj]),
          public = fields.get("public").map(json => json.convertTo[Boolean]),
          snapshotId = fields.get("snapshot_id").map(json => json.convertTo[String]),
          tracks = fields.get("tracks").map(json => json.convertTo[TracksObj]),
          objType = fields.get("type").map(json => json.convertTo[String]),
          uri = fields.get("uri").map(json => json.convertTo[String])
        )
      }
    }
}