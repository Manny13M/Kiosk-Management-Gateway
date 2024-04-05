package ca.sheridancollege.martmanu.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.martmanu.beans.Toothbrush;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/gatewayAPI")
public class GatewayToothbrushRestController {

	final private String TOOTHBRUSHES_REST_URL = "http://localhost:8082/toothbrushes";

	@GetMapping("/findAllToothbrushes")
	public Toothbrush[] getAllToothbrushes(RestTemplate restTemplate){
		
		ResponseEntity<Toothbrush[]> responseEntity = restTemplate.getForEntity(TOOTHBRUSHES_REST_URL + "/findAll", Toothbrush[].class);
		
		return responseEntity.getBody();
	}
	
	@GetMapping("/findToothbrushById/{id}")
	public Toothbrush getToothbrushById(RestTemplate restTemplate, @PathVariable Long id){
		
		ResponseEntity<Toothbrush> responseEntity = restTemplate.getForEntity(TOOTHBRUSHES_REST_URL + "/findById/" + id, Toothbrush.class);
		
		return responseEntity.getBody();
	}
	
	@PostMapping("/saveToothbrush")
	public Toothbrush[] saveToothbrush(RestTemplate restTemplate, @RequestBody Toothbrush toothbrush){
		
		ResponseEntity<Toothbrush[]> responseEntity = restTemplate.postForEntity(TOOTHBRUSHES_REST_URL + "/save", toothbrush, Toothbrush[].class);
		
		return responseEntity.getBody();
	}
	
	@DeleteMapping("/deleteToothbrush/{id}")
	public Toothbrush[] deleteToothbrush(RestTemplate restTemplate, @PathVariable Long id){
	    
		// Perform DELETE request
	    restTemplate.delete(TOOTHBRUSHES_REST_URL + "/delete/" + id);
	    
	    // Get updated list of toothbrushes
	    ResponseEntity<Toothbrush[]> responseEntity = restTemplate.getForEntity(TOOTHBRUSHES_REST_URL + "/findAll", Toothbrush[].class);

		return responseEntity.getBody();
	}
}
