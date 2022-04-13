package com.boots.completedgamestracker.context

import com.boots.completedgamestracker.controller.GamesController
import com.boots.completedgamestracker.repository.GamesRepository
import com.boots.completedgamestracker.service.GamesService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GamesContextTests {

    @Autowired
    private lateinit var gamesController: GamesController

    @Autowired
    private lateinit var gamesService: GamesService

    @Autowired
    private lateinit var gamesRepository: GamesRepository

    @Test
    fun contextLoadsGamesController() = Assertions.assertNotNull(gamesController)

    @Test
    fun contextLoadsGamesService() = Assertions.assertNotNull(gamesService)

    @Test
    fun contextLoadsGamesRepository() = Assertions.assertNotNull(gamesRepository)

}