package com.boots.completedgamestracker.config

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories(basePackages = ["com.boots.completedgamestracker"])
class MongoConfig : AbstractMongoClientConfiguration() {

    override fun getDatabaseName(): String = "completed-games-tracker"

    override fun mongoClient(): MongoClient =
        MongoClients.create(
            MongoClientSettings
                .builder()
                .applyConnectionString(
                    ConnectionString("mongodb://localhost:27017/completed-games-tracker")
                )
                .build()
        )

}