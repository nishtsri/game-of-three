package org.example;

import java.util.Random;

import org.example.player1.Player1;
import org.example.player2.Player2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GameOfThreeApplication implements ApplicationRunner{

	public static final Logger LOG = LoggerFactory.getLogger(GameOfThreeApplication.class);

	@Autowired
	Player1 player1;
	
	@Autowired
	Player2 player2;
	
	@Value(value = "${start-with}")
	String startWith;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GameOfThreeApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Random random = new Random();
		int start = random.nextInt(100);
		if(!startWith.isEmpty() && startWith.equalsIgnoreCase("player2")) {
			LOG.info(" Player 1 started with number : " + start);
			player2.sendInputToPlayer1(start);
		}else {
			LOG.info(" Player 2 started with number : " + start);
			player1.sendInputToPlayer2(start);
		}
	}
}
