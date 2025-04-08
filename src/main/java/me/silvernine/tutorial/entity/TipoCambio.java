package me.silvernine.tutorial.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "`tipocambio`")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoCambio {

   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "monedaorigen", length = 10)
   private String monedaorigen;

   @Column(name = "monedadestino", length = 10)
   private String monedadestino;

   @Column(name = "cambio")
   private Double cambio;
   
}