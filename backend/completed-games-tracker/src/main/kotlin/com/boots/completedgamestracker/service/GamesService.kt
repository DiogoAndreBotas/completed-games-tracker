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

    fun processTextFile(file: MultipartFile): Int =
        file
            .inputStream
            .bufferedReader()
            .readLines()
            .map { gamesRepository.insert(Game(name = it)) }
            .count()

    fun getAllGames(): List<Game> = gamesRepository.findAll()

    fun getGameById(id: ObjectId): Game = gamesRepository.findById(id).get()

}