package ras.spotify.model

import spray.json.DefaultJsonProtocol.{BooleanJsonFormat, IntJsonFormat, StringJsonFormat, listFormat}
import spray.json.{JsValue, RootJsonFormat}

case class SimpleShowObj(
                          availableMarkets: List[String],
                          copyrights: List[CopyrightObj],
                          description: String,
                          htmlDescription: String,
                          explicit: Boolean,
                          externalUrls: ExtUrlsObj,
                          href: String,
                          spotifyId: String,
                          images: List[ImgObj],
                          externalHosted: Boolean,
                          languages: List[String],
                          mediaType: String,
                          name: String,
                          publisher: String,
                          objType: String,
                          uri: String,
                          totalEpisodes: Int
                        )
object SimpleShowObj{
  implicit val jsonFormat: RootJsonFormat[SimpleShowObj] =
    new RootJsonFormat[SimpleShowObj] {
      override def write(obj: SimpleShowObj): JsValue = ???

      override def read(json: JsValue): SimpleShowObj = {
        val fields = json.asJsObject().fields
        SimpleShowObj(
          availableMarkets = fields.apply("available_markets").convertTo[List[String]],
          copyrights = fields.apply("copyrights").convertTo[List[CopyrightObj]],
          description = fields.apply("description").convertTo[String],
          htmlDescription = fields.apply("html_description").convertTo[String],
          explicit = fields.apply("explicit").convertTo[Boolean],
          externalUrls = fields.apply("external_urls").convertTo[ExtUrlsObj],
          href = fields.apply("href").convertTo[String],
          spotifyId = fields.apply("id").convertTo[String],
          images = fields.apply("images").convertTo[List[ImgObj]],
          externalHosted = fields.apply("is_externally_hosted").convertTo[Boolean],
          languages = fields.apply("langauges").convertTo[List[String]],
          mediaType = fields.apply("media_type").convertTo[String],
          name = fields.apply("name").convertTo[String],
          publisher = fields.apply("publisher").convertTo[String],
          objType = fields.apply("type").convertTo[String],
          uri = fields.apply("uri").convertTo[String],
          totalEpisodes = fields.apply("total_episodes").convertTo[Int]
        )
      }
    }
}
