package me.silvernine.tutorial.dto.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.silvernine.tutorial.entity.TarjetaCredito;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarjetaDtoRequest {

	@NotEmpty(message = "Titular cannot be empty")
	@Size(min = 7, max = 50)
	@NotNull
	private String titular;

	@NotEmpty(message = "Número tarjeta cannot be empty")
	@Size(min = 16, max = 50)
	@NotNull   
	private String numerotarjeta;

	@NotEmpty(message = "Fecha de expiración cannot be empty")
	@Size(min = 10, max = 50)
	@NotNull
	private String fechaExpiracion;

	@NotEmpty(message = "CVV cannot be empty")
	@Size(min = 3, max = 10)
	@NotNull
	private String cvv; 
	
}
