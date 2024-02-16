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
public class TarjetaDtoRequest {


	private int id;
	
	
	private String titular;

 
	private String numeroTarjeta;


	private String fechaExpiracion;

	private String cvv; 
	
}
