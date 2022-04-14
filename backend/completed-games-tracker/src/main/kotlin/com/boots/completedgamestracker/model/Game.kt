package com.boots.completedgamestracker.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "games")
class Game (
    @Id
    val id: String = ObjectId().toString(),
    val name: String,
    val platform: String = "",
    val hoursPlayed: String = "",
    val releaseDate: String = "",
    val steamStoreLink: String = "",
    val developer: String = "",
    val publisher: String = "",
    val image: String = ""
)
