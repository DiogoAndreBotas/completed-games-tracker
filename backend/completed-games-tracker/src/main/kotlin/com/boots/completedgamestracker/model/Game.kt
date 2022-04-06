package com.boots.completedgamestracker.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "games")
class Game (
    @Id
    val id: String = ObjectId().toString(),
    val name: String
)
