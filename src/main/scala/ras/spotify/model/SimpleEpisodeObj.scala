package ras.spotify.model

import spray.json.DefaultJsonProtocol.{BooleanJsonFormat, IntJsonFormat, StringJsonFormat, listFormat}
import spray.json.{JsValue, RootJsonFormat}

case class SimpleEpisodeObj(
                             audioPreviewUrl: Option[String],
                             description: String,
                             htmlDescription: String,
                             durationMs: Int,
                             explicit: Boolean,
                             externalUrls: ExtUrlsObj,
                             href: String,
                             spotifyId: String,
                             images: List[ImgObj],
                             externalHosted: Boolean,
                             playable: Boolean,
                             languages: List[String],
                             name: String,
                             releaseDate: String,
                             releaseDatePrecision: String,
                             resumePoint: ResumeObj,
                             objType: String,
                             uri: String,
                             restrictions: RestrictionReasonObj
                           )
object SimpleEpisodeObj{
  implicit val jsonFormat: RootJsonFormat[SimpleEpisodeObj] =
    new RootJsonFormat[SimpleEpisodeObj] {
      override def write(obj: SimpleEpisodeObj): JsValue = ???

      override def read(json: JsValue): SimpleEpisodeObj = {
        val fields = json.asJsObject().fields
        SimpleEpisodeObj(
          audioPreviewUrl = fields.get("audio_preview_url").map(json => json.convertTo[String]),
          description = fields.apply("description").convertTo[String],
          htmlDescription = fields.apply("html_description").convertTo[String],
          durationMs = fields.apply("duration_ms").convertTo[Int],
          explicit = fields.apply("explicit").convertTo[Boolean],
          externalUrls = fields.apply("external_urls").convertTo[ExtUrlsObj],
          href = fields.apply("href").convertTo[String],
          spotifyId = fields.apply("id").convertTo[String],
          images = fields.apply("images").convertTo[List[ImgObj]],
          externalHosted = fields.apply("is_externally_hosted").convertTo[Boolean],
          playable = fields.apply("is_playable").convertTo[Boolean],
          languages = fields.apply("languages").convertTo[List[String]],
          name = fields.apply("name").convertTo[String],
          releaseDate = fields.apply("release_date").convertTo[String],
          releaseDatePrecision = fields.apply("release_date_precision").convertTo[String],
          resumePoint = fields.apply("resume_point").convertTo[ResumeObj],
          objType = fields.apply("type").convertTo[String],
          uri = fields.apply("uri").convertTo[String],
          restrictions = fields.apply("restrictions").convertTo[RestrictionReasonObj]
        )
      }
    }
}
