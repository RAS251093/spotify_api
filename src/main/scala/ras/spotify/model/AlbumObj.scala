package ras.spotify.model

case class AlbumObject(
                      albumType: String,
                      totalTracks: Integer,
                      availableMarkets: List[String],
                      externalUrls: extUrls,
                      href: String,
                      spotifyId: String,
                      images: imgObject,
                      name: String,
                      releaseDate: String,
                      releaseDatePrecision: String,
                      restrictions: Option[RestrictionReason],
                      objType: String,
                      uri: String,
                      artists: List[Si]
                      )
