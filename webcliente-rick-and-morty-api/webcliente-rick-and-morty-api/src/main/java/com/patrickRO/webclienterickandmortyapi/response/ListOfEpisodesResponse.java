package com.patrickRO.webclienterickandmortyapi.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Data;

@JsonAutoDetect(fieldVisibility = Visibility.ANY) // Para ler os valores do campo além de mapear.
@Data
public class ListOfEpisodesResponse {
	
	private List<EpisodeResponse> result;

}
