package me.silvernine.tutorial.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.silvernine.tutorial.entity.TarjetaCredito;


@Getter
@Setter
public class TarjetaDtoRequest {


	private int id;
	
	
	private String titular;

 
	private String numeroTarjeta;


	private String fechaExpiracion;

	private String cvv; 
	
}
