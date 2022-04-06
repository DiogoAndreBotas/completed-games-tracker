package com.boots.completedgamestracker.model

import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Id

@Document
class Game (
    @Id
    val name: String
)