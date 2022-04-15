package com.boots.completedgamestracker.controller

import com.boots.completedgamestracker.model.Game
import com.boots.completedgamestracker.model.UploadGamesResponse
import com.boots.completedgamestracker.service.GamesService
import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("games")
class GamesController (
    val gamesService: GamesService
) {

    @PostMapping
    fun postGame(@RequestBody game: Game) = gamesService.createGame(game)

    @PostMapping("/upload")
    fun uploadTextFile(@RequestPart file: MultipartFile) = UploadGamesResponse(gamesService.processTextFile(file))

    @GetMapping
    fun getAllGames() = gamesService.getAllGames()

    @GetMapping("/{id}")
    fun getGame(@PathVariable("id") id: ObjectId) = gamesService.getGame(id)

    @DeleteMapping("/{id}")
    fun deleteGame(@PathVariable("id")id: ObjectId) = gamesService.deleteGame(id)

}