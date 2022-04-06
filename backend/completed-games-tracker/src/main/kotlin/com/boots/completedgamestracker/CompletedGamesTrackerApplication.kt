package com.boots.completedgamestracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class CompletedGamesTrackerApplication

fun main(args: Array<String>) {
	runApplication<CompletedGamesTrackerApplication>(*args)
}
