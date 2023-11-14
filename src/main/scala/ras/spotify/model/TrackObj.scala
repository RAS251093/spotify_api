package ras.spotify.model

case class TrackObject(
                        album: Option[AlbumObj],
                        artists: Option[ArtistObj],
                        availableMarkets: List[String],
                        discNum: Option[Integer],
                        duraction: Option[Integer],
                        explicit: Option[Boolean],
                        externalId: Option[ExternalID],
                        externalUrls: Option[ExternalURL],
                        href: Option[String],
                        id: Option[ID],
                        isPlayable: Option[Boolean],
                        linkedFrom: Option[TrackObject],
                        restrictions: Option[RestrictionReason],
                        name: Option[String],
                        popularity: Option[Integer],
                        previewUrl: Option[String],
                        trackNum: Option[Integer],
                        objType: Option[String],
                        uri: Option[String],
                        isLocal: Option[Boolean]
                      )
