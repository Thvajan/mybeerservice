package me.learning.mybeerservice.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import me.learning.mybeerservice.web.model.BeerDTO;
import me.learning.mybeerservice.web.model.BeerStyle;

@RestController
@Slf4j
@RequestMapping("/api/v1/beer")
public class BeerController {

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId") UUID uuid) {
		log.info("getBeerById service was invoked");
		return new ResponseEntity<BeerDTO>(BeerDTO.builder().beerStyle(BeerStyle.DRAUGHT).beerName("BeerTown").build(),
				HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BeerDTO> saveNewBeer(@RequestBody BeerDTO beerDTO) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{beerId}")
	public ResponseEntity<BeerDTO> updateBeerById(@PathVariable("beerId") UUID uuid, @RequestBody BeerDTO beerDTO) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
