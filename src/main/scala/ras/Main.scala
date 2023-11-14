package ras

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import ras.spotify.model.SpotifyClient

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Success
import scala.util.Failure

object Main {
  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "Main")
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext: ExecutionContext = system.executionContext

    val clientID = ""
    val clientSecret = ""
    val songUrl = "https://open.spotify.com/track/0QhoniumuDQIQY46aIebRq?si=202e1b1d660d4275"

    val spotify = new SpotifyClient()
    val accessToken = spotify.tokenRequest(clientID, clientSecret)
    val trackId = spotify.getTrackIdFromUrl(songUrl)

    accessToken.onComplete ({
      case Success(token) =>
        spotify.lookUpTrack(trackId, token)

      case Failure(_) => s"No access token found"
    })

  }
}

