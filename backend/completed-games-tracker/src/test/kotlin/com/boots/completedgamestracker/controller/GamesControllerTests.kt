package com.boots.completedgamestracker.controller

import com.boots.completedgamestracker.model.Game
import com.boots.completedgamestracker.service.GamesService
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.bson.types.ObjectId
import org.junit.jupiter.api.BeforeEach
import org.mockito.kotlin.any
import org.springframework.web.multipart.MultipartFile

class GamesControllerTests {

    private val gamesService: GamesService = mock()

    private val gamesController = GamesController(gamesService)

    @Test
    fun postGamesReturnsCreatedGame() {
        whenever(gamesService.createGame(any()))
            .thenReturn(Game("random_id", "God of War"))

        val createdGame = gamesController.postGame(Game(name = "God of War"))

        assertThat(createdGame.id).isEqualTo("random_id")
        assertThat(createdGame.name).isEqualTo("God of War")
    }

    @Test
    fun postGamesUploadWithTextFileWithContentReturnsCountOfGames() {
        whenever(gamesService.processTextFile(any()))
            .thenReturn(10)

        val multipartFile: MultipartFile = mock()
        val uploadGamesResponse = gamesController.uploadTextFile(multipartFile)

        assertThat(uploadGamesResponse.numberOfCreatedGames).isEqualTo(10)
    }

    @Test
    fun getAllGamesReturnsEmptyList() {
        whenever(gamesService.getAllGames())
            .thenReturn(emptyList())

        val games = gamesController.getAllGames()

        assertThat(games.size).isZero
    }

    @Test
    fun getAllGamesReturnsListWithGames() {
        whenever(gamesService.getAllGames())
            .thenReturn(listOf(
                Game(name = "Yakuza 0"),
                Game(name = "Yakuza Kiwami"),
                Game(name = "Yakuza Kiwami 2"),
                Game(name = "Yakuza 3")
            ))

        val games = gamesController.getAllGames()

        assertThat(games.size).isEqualTo(4)
    }

    @Test
    fun getGameByIdReturnsGame() {
        whenever(gamesService.getGameById(any()))
            .thenReturn(Game(name = "The Darkside Detective"))

        val game = gamesController.getGameById(ObjectId.get())

        assertThat(game.name).isEqualTo("The Darkside Detective")
    }
}