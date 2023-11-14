package ras.spotify.model

import spray.json.DefaultJsonProtocol.{BooleanJsonFormat, IntJsonFormat, StringJsonFormat, listFormat}
import spray.json.{JsValue, RootJsonFormat}

case class SimpleAudiobookObj(
                             authors: List[AuthorObj],
                             availableMarkets: List[String],
                             copyrights: List[CopyrightObj],
                             description: String,
                             htmlDescription: String,
                             edition: String,
                             explicit: Boolean,
                             externalUrls: ExtUrlsObj,
                             href: String,
                             spotifyId: String,
                             images: List[ImgObj],
                             languages: List[String],
                             mediaType: String,
                             name: String,
                             narrators: List[NarratorObj],
                             publisher: String,
                             objType: String,
                             uri: String,
                             totalChapters: Int
                             )
object SimpleAudiobookObj{
  implicit val jsonFormat: RootJsonFormat[SimpleAudiobookObj] =
    new RootJsonFormat[SimpleAudiobookObj] {
      override def write(obj: SimpleAudiobookObj): JsValue = ???

      override def read(json: JsValue): SimpleAudiobookObj = {
        val fields = json.asJsObject().fields
        SimpleAudiobookObj(
          authors = fields.apply("authors").convertTo[List[AuthorObj]],
          availableMarkets = fields.apply("available_markets").convertTo[List[String]],
          copyrights = fields.apply("copyrights").convertTo[List[CopyrightObj]],
          description = fields.apply("description").convertTo[String],
          htmlDescription = fields.apply("html_description").convertTo[String],
          edition = fields.apply("edition").convertTo[String],
          explicit = fields.apply("explicit").convertTo[Boolean],
          externalUrls = fields.apply("external_urls").convertTo[ExtUrlsObj],
          href = fields.apply("href").convertTo[String],
          spotifyId = fields.apply("id").convertTo[String],
          images = fields.apply("images").convertTo[List[ImgObj]],
          languages = fields.apply("languages").convertTo[List[String]],
          mediaType = fields.apply("media_type").convertTo[String],
          name = fields.apply("name").convertTo[String],
          narrators = fields.apply("narrators").convertTo[List[NarratorObj]],
          publisher = fields.apply("publisher").convertTo[String],
          objType = fields.apply("type").convertTo[String],
          uri = fields.apply("uri").convertTo[String],
          totalChapters = fields.apply("total_chapters").convertTo[Int]
        )
      }
    }
}
