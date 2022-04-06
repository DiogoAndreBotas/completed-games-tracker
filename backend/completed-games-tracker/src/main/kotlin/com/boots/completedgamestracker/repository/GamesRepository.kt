package com.boots.completedgamestracker.repository

import com.boots.completedgamestracker.model.Game
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface GamesRepository : MongoRepository<Game, ObjectId>
