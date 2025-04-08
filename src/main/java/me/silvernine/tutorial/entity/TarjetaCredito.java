package me.silvernine.tutorial.entity;

import java.util.Set;
import java.util.stream.Collectors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.silvernine.tutorial.dto.AuthorityDto;
import me.silvernine.tutorial.dto.UserDto;
import me.silvernine.tutorial.dto.request.TarjetaDtoRequest;


@Entity
@Table(name = "`tarjetacredito`")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TarjetaCredito {

   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Id;

   @Column(name = "titular", length = 50, unique = false)
   private String titular;

   
   @Column(name = "numerotarjeta", length = 50, unique = true)
   private String numerotarjeta;

   @Column(name = "fecha_expiracion", length = 5)
   private String fechaExpiracion;

   @Column(name = "cvv", length = 3)
   private String cvv;
   
   public static TarjetaCredito from(TarjetaDtoRequest tarjetaDto) {
	      if(tarjetaDto == null) return null;
	      return TarjetaCredito.builder()
	              .titular(tarjetaDto.getTitular())
	              .numerotarjeta(tarjetaDto.getNumeroTarjeta())
	              .fechaExpiracion(tarjetaDto.getFechaExpiracion())
	              .cvv(tarjetaDto.getCvv())
	              .build();
	   }

}