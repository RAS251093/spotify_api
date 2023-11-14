/*
package ras.spotify.model

import spray.json.DefaultJsonProtocol.StringJsonFormat
import spray.json.{JsValue, RootJsonFormat}

case class SearchTrackResponse(name: Option[String], extID: Option[ExtIdObj], id: Option[String])

object  SearchTrackResponse{
  implicit val jsonFormat: RootJsonFormat[SearchTrackResponse] =
    new RootJsonFormat[SearchTrackResponse] {
      override def write(obj: SearchTrackResponse): JsValue = ???

      override def read(json: JsValue): SearchTrackResponse = {
        val fields = json.asJsObject().fields
        SearchTrackResponse(
          name = fields.get("name").map(json => json.convertTo[String]),
          extID = fields.get("external_ids").map(json => json.convertTo[ExtIdObj]),
          id = fields.get("id").map(json => json.convertTo[String])
        )
      }
    }
}
*/
