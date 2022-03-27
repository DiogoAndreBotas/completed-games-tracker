package com.boots.completedgamestracker.service

import com.boots.completedgamestracker.model.Game
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class GamesService {

    fun processTextFile(file: MultipartFile): List<Game> =
        file
            .inputStream
            .bufferedReader()
            .readLines()
            .map { Game(it) }

}