package com.boots.completedgamestracker.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Game (
    @Id
    val name: String
)