package com.patrickRO.webclienterickandmortyapi.client;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.patrickRO.webclienterickandmortyapi.response.CharacterResponse;
import com.patrickRO.webclienterickandmortyapi.response.EpisodeResponse;
import com.patrickRO.webclienterickandmortyapi.response.ListOfEpisodesResponse;
import com.patrickRO.webclienterickandmortyapi.response.LocationResponse;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@Data
public class RickAndMortyClient {
	
	
	//@Value("${urlbase.rickandmorty}") 
	private String urlBase = "https://rickandmortyapi.com/api";
	
	private final WebClient webClient;

	public RickAndMortyClient(WebClient.Builder builder) {
		log.info("BaseUrl : [{}] " + urlBase);
		webClient = builder.baseUrl(urlBase).build();
	}
	
	public Mono<CharacterResponse> FindAndCharacterById(String id) {
		log.info("buscando o personagem com o id [{}]",id);
		return webClient
				.get()
				.uri("/character/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("verifique os parametros informados")))
				.bodyToMono(CharacterResponse.class);
	}
	
	public Mono<LocationResponse> findAndLocationByid(String id){
		log.info("Busca o personagem com id [{}]" , id);
		return webClient
				.get()
				.uri("/location/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("verifique os parametros informados")))
				.bodyToMono(LocationResponse.class);
	}
	
	public Mono<EpisodeResponse> findAndEpisodeByid(String id){
		log.info("Busca o episodeio com id [{}]" , id);
		return webClient
				.get()
				.uri("/episode/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("verifique os parametros informados")))
				.bodyToMono(EpisodeResponse.class);
	}
	
	public Flux<ListOfEpisodesResponse> getAllEpisodes(){
		log.info("Busca todos episodios" );
		return webClient
				.get()
				.uri("/episode/")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("verifique os parametros informados")))
				.bodyToFlux(ListOfEpisodesResponse.class);
	} 

}
