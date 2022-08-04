package com.patrickRO.webclienterickandmortyapi.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Data;

@JsonAutoDetect(fieldVisibility = Visibility.ANY) // Para ler os valores do campo além de mapear.
@Data
public class CharacterResponse {
	
	private String id;
	private String name;
	private String status;
	private String species;
	private String image;
	private List<String> episode;

}
