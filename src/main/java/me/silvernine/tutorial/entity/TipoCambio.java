package me.silvernine.tutorial.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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