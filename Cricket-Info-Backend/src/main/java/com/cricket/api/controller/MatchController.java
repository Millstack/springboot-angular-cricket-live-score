package com.cricket.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.api.dto.Match;
import com.cricket.api.service.MatchService;

@RestController
@RequestMapping("/match")
public class MatchController {

	private MatchService service;
	
	public MatchController(MatchService service) {
		super();
		this.service = service;
	}
	
	//getting all live matches
	@GetMapping("/live")
	public ResponseEntity<List<Match>> getLiveMatches(){ 
		return new ResponseEntity<>(this.service.getLiveMatches(), HttpStatus.OK);
	}
	
	//get all matches
	@GetMapping("/")
	public ResponseEntity<List<Match>> getAllMatch(){
		return new ResponseEntity<>(this.service.getAllMatches(), HttpStatus.OK);
	}
	
	//get point table
	@GetMapping("/point-table")
	public ResponseEntity<?> getPointTable(){
		return new ResponseEntity<>(this.service.getPointTable(), HttpStatus.OK);
	}
}
