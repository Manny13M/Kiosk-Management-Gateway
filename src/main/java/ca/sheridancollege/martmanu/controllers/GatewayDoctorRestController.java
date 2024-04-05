package ca.sheridancollege.martmanu.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.martmanu.beans.Doctor;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/gatewayAPI")
public class GatewayDoctorRestController {
	
	final private String DOCTORS_REST_URL = "http://localhost:8081/doctors";
	
	@GetMapping("/findAllDoctors")
	public Doctor[] getAllDoctors(RestTemplate restTemplate){
		
		ResponseEntity<Doctor[]> responseEntity = restTemplate.getForEntity(DOCTORS_REST_URL + "/findAll", Doctor[].class);
		
		return responseEntity.getBody();
	}
	
	@GetMapping("/findDoctorById/{id}")
	public Doctor getDoctorById(RestTemplate restTemplate, @PathVariable Long id){
		
		ResponseEntity<Doctor> responseEntity = restTemplate.getForEntity(DOCTORS_REST_URL + "/findById/" + id, Doctor.class);
		
		return responseEntity.getBody();
	}
	
	@PostMapping("/saveDoctor")
	public Doctor[] saveDoctor(RestTemplate restTemplate, @RequestBody Doctor doctor){
		
		ResponseEntity<Doctor[]> responseEntity = restTemplate.postForEntity(DOCTORS_REST_URL + "/save", doctor, Doctor[].class);
		
		return responseEntity.getBody();
	}
}
