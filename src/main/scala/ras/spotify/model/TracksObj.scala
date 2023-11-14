package ras.spotify.model

import spray.json.DefaultJsonProtocol.{IntJsonFormat, StringJsonFormat}
import spray.json.{JsValue, RootJsonFormat}

case class TracksObj(
                    href: Option[String],
                    total: Option[Int]
                    )

object TracksObj{
  implicit val jsonFormat: RootJsonFormat[TracksObj] =
    new RootJsonFormat[TracksObj] {
      override def write(obj: TracksObj): JsValue = ???

      override def read(json: JsValue): TracksObj = {
        val fields = json.asJsObject().fields
        TracksObj(
          href = fields.get("href").map(json => json.convertTo[String]),
          total = fields.get("total").map(json => json.convertTo[Int])
        )
      }
    }
}
