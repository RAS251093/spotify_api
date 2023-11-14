package ras.spotify.model

import akka.actor.typed.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers.{Authorization, BasicHttpCredentials, OAuth2BearerToken}
import akka.http.scaladsl.model.HttpRequest
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.model.HttpMethods._

import scala.concurrent.{ExecutionContext, Future}

final class SpotifyClient(implicit system: ActorSystem[Nothing], executionContext: ExecutionContext) {

  def tokenRequest(clientId: String, clientSecret: String): Future[String] = {
    val httpRequest = HttpRequest(
      method = POST,
      uri = "https://accounts.spotify.com/api/token",
      headers = List(Authorization(BasicHttpCredentials(clientId, clientSecret))),
      entity = HttpEntity(ContentTypes.`application/x-www-form-urlencoded`, "grant_type=client_credentials")
    )
//get http out => remove actorsystem?
    Http().singleRequest(httpRequest)
      .flatMap {res => Unmarshal(res).to[AccessTokenResponse]}
      .map {res => res.accessToken}
  }

/*  def lookUpTrack(trackID: String, accessToken: String): Unit = {
    val uriString = s"https://api.spotify.com/v1/tracks/$trackID"
    val httpSongRequest = HttpRequest(
      method = GET,
      uri = uriString,
      headers = List(Authorization(OAuth2BearerToken(accessToken)))
    )

    Http().singleRequest(httpSongRequest)
      .flatMap { songRes => Unmarshal(songRes).to[SearchTrackResponse] }
      .map { songRes => println(songRes.name, songRes.extID) }
  }*/

  def getTrackIdFromUrl(url: String): String = {
    val endOfIdChar = 22
    url.stripPrefix("https://open.spotify.com/track/").slice(0, endOfIdChar)
  }

}
