package ras.spotify.model

import spray.json.DefaultJsonProtocol.{BooleanJsonFormat, IntJsonFormat}
import spray.json.{JsValue, RootJsonFormat}

case class ResumeObj(
                    fullyPlayed: Option[Boolean],
                    resumePositionMs: Option[Int]
                    )
object ResumeObj{
  implicit val jsonFormat: RootJsonFormat[ResumeObj] =
    new RootJsonFormat[ResumeObj] {
      override def write(obj: ResumeObj): JsValue = ???

      override def read(json: JsValue): ResumeObj = {
        val fields = json.asJsObject().fields
        ResumeObj(
          fullyPlayed = fields.get("fully_played").map(json => json.convertTo[Boolean]),
          resumePositionMs = fields.get("resume_position_ms").map(json => json.convertTo[Int])
        )
      }
    }
}
