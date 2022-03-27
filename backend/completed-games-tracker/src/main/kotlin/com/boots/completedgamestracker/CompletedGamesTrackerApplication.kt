package com.boots.completedgamestracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CompletedGamesTrackerApplication

fun main(args: Array<String>) {
	runApplication<CompletedGamesTrackerApplication>(*args)
}
