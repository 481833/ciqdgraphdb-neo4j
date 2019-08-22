package com.ciqd.graphdb.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("com.ciqd.graphdb.neo4j.repository")
public class Neo4jgraphdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(Neo4jgraphdbApplication.class, args);
	}

}