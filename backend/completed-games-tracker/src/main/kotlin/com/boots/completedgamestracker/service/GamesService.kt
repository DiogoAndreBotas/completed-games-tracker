package com.boots.completedgamestracker.service

import com.boots.completedgamestracker.model.Game
import com.boots.completedgamestracker.repository.GamesRepository
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class GamesService(
    val gamesRepository: GamesRepository
) {

    fun createGame(game: Game): Game = gamesRepository.save(game)

    fun processTextFile(file: MultipartFile): List<Game> =
        file
            .inputStream
            .bufferedReader()
            .readLines()
            .map { Game(it) }

}