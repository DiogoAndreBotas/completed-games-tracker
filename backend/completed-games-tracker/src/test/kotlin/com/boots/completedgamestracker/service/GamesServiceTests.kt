package com.boots.completedgamestracker.service

import com.boots.completedgamestracker.model.Game
import com.boots.completedgamestracker.repository.GamesRepository
import org.assertj.core.api.Assertions.assertThat
import org.bson.types.ObjectId
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.springframework.mock.web.MockMultipartFile
import java.io.File
import java.io.FileInputStream
import java.util.*

class GamesServiceTests {

    private val gamesRepository: GamesRepository = mock()

    private val gamesService = GamesService(gamesRepository)

    @Test
    fun createGameReturnsCreatedGame() {
        whenever(gamesRepository.insert(Mockito.any(Game::class.java)))
            .thenReturn(Game("random_id", "God of War"))

        val createdGame = gamesService.createGame(Game(name = "God of War"))

        assertThat(createdGame.id).isEqualTo("random_id")
        assertThat(createdGame.name).isEqualTo("God of War")
    }

    @Test
    fun emptyTextFileIsProcessedAndReturnsCount() {
        val file = File("src/test/resources/empty_text_file.txt")
        val inputStream = FileInputStream(file)
        val multipartFile = MockMultipartFile(
            "file",
            file.name,
            "text/plain",
            inputStream.readAllBytes()
        )

        val createdGamesCount = gamesService.processTextFile(multipartFile)
        assertThat(createdGamesCount).isZero
    }

    @Test
    fun textFileWithContentIsProcessedAndReturnsCount() {
        val file = File("src/test/resources/file_with_10_game_names.txt")
        val inputStream = FileInputStream(file)
        val multipartFile = MockMultipartFile(
            "file",
            file.name,
            "text/plain",
            inputStream.readAllBytes()
        )

        val createdGamesCount = gamesService.processTextFile(multipartFile)
        assertThat(createdGamesCount).isEqualTo(10)
    }

    @Test
    fun getAllGamesReturnsEmptyList() {
        whenever(gamesRepository.findAll())
            .thenReturn(emptyList())

        val games = gamesService.getAllGames()

        assertThat(games.size).isZero
    }

    @Test
    fun getAllGamesReturnsListWithGames() {
        whenever(gamesRepository.findAll())
            .thenReturn(listOf(
                Game(name = "Yakuza 0"),
                Game(name = "Yakuza Kiwami"),
                Game(name = "Yakuza Kiwami 2"),
                Game(name = "Yakuza 3")
            ))

        val games = gamesService.getAllGames()

        assertThat(games.size).isEqualTo(4)
    }

    @Test
    fun getGameReturnsGame() {
        whenever(gamesRepository.findById(any()))
            .thenReturn(Optional.of(Game(name = "The Darkside Detective")))

        val game = gamesService.getGame(ObjectId.get())

        assertThat(game.name).isEqualTo("The Darkside Detective")
    }

}