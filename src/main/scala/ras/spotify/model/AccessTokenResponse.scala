package ras
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._
import spray.json.{JsValue, RootJsonFormat}
import spray.json._

import scala.concurrent.duration.{DurationInt, FiniteDuration}

case class AccessTokenResponse(accessToken: String, tokenType: String, expiresIn: FiniteDuration)

object AccessTokenResponse{
  implicit val jsonFormat: RootJsonFormat[AccessTokenResponse] =
    new RootJsonFormat[AccessTokenResponse] {
      override def write(obj: AccessTokenResponse): JsValue = ???

      override def read(json: JsValue): AccessTokenResponse = {
        val fields = json.asJsObject().fields
        val rawExpiresIn = fields("expires_in").convertTo[Int]
        AccessTokenResponse(
          accessToken = fields("access_token").convertTo[String],
          tokenType = fields("token_type").convertTo[String],
          expiresIn = rawExpiresIn.seconds
        )

      }
    }
}