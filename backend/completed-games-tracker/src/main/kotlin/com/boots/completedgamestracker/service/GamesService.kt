package com.boots.completedgamestracker.service

import com.boots.completedgamestracker.model.Game
import com.boots.completedgamestracker.repository.GamesRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class GamesService(
    val gamesRepository: GamesRepository
) {

    fun createGame(game: Game): Game = gamesRepository.insert(game)

    fun processTextFile(file: MultipartFile): List<Game> =
        file
            .inputStream
            .bufferedReader()
            .readLines()
            .map { gamesRepository.insert(Game(name = it)) }

    fun getAllGames(): List<Game> = gamesRepository.findAll()

    fun getGame(id: ObjectId): Game = gamesRepository.findById(id).get()

    fun deleteGame(id: ObjectId): ObjectId {
        gamesRepository.delete(
            gamesRepository.findById(id).get()
        )
        return id
    }

}