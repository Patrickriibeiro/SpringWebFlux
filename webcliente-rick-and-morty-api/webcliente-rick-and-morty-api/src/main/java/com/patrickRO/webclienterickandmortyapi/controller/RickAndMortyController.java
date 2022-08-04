package com.patrickRO.webclienterickandmortyapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrickRO.webclienterickandmortyapi.client.RickAndMortyClient;
import com.patrickRO.webclienterickandmortyapi.response.CharacterResponse;
import com.patrickRO.webclienterickandmortyapi.response.EpisodeResponse;
import com.patrickRO.webclienterickandmortyapi.response.ListOfEpisodesResponse;
import com.patrickRO.webclienterickandmortyapi.response.LocationResponse;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webcliente")
public class RickAndMortyController {

	RickAndMortyClient rickAndMortyClient;
	
	@GetMapping("/character/{id}")
	public Mono<CharacterResponse> getCharacterById(@PathVariable String id){
		return rickAndMortyClient.FindAndCharacterById(id);
	}
	
	
	@GetMapping("/location/{id}")
	public Mono<LocationResponse> getLocantionById(@PathVariable String id){
		return rickAndMortyClient.findAndLocationByid(id);
	}
	
	@GetMapping("/episode/{id}")
	public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id){
		return rickAndMortyClient.findAndEpisodeByid(id);
	}
	
	@GetMapping("/episodes")
	public Flux<ListOfEpisodesResponse> getEpisodeById(){
		return rickAndMortyClient.getAllEpisodes();
	}
}
