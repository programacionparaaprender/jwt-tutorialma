package me.silvernine.tutorial.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.silvernine.tutorial.dto.LoginDto;

import com.fasterxml.jackson.annotation.JsonProperty;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoCambioRequest {
	@NotNull
	@Size(min = 2, max = 10)
	@JsonProperty("monedaorigen")
	private String monedaorigen;
	
	@NotNull   
	@Size(min = 2, max = 10)
	@JsonProperty("monedadestino")
	private String monedadestino;
	
	@NotNull
	@JsonProperty("monto")
	private String monto;
}