package org.example.player2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/api")
public class Player2 {
	
	public static final Logger LOG = LoggerFactory.getLogger(Player2.class);

	@GetMapping("/player2/{number}")
    public ResponseEntity<Integer> getResponseFromPlayer2(@PathVariable Integer number) {
		LOG.debug("3. Reached with number : " + number);
        int plusOne = number + 1;
        int minusOne = number - 1;
			if(plusOne == 3 || minusOne == 3 || number == 3) {
				LOG.info("Player 2 : Winner!!");
				return ResponseEntity.ok(0);
			}else if(plusOne%3 == 0) {
				number = plusOne/3;
			}else if(minusOne%3 == 0) {
				number = minusOne/3;
			}else {
				number = number/3;
			}
		LOG.debug("4. The number now is : " + number);
        return sendInputToPlayer1(number);
    }

	public ResponseEntity<Integer> sendInputToPlayer1(Integer number) {
		String url = "http://localhost:8080/player1/"+number;
		HttpEntity<Integer> entity = new HttpEntity<Integer>(number);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Integer> response = ResponseEntity.ok(-1);
		
		try {
			LOG.debug("5. Sending request at url : " + url);
			response = restTemplate.exchange(url, HttpMethod.GET, entity, Integer.class);
		}catch(HttpClientErrorException e) {
			LOG.error("Excpetion occurred at 333 : " + e.getMessage());
		}
		return response;
	}
	

}
