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
@Table(name = "`menu`")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Id;

   @Column(name = "nombre", length = 32, unique = false)
   private String nombre;

   @Column(name = "url", length = 32)
   private String url;
   
   @Column(name = "hijo")
   private int hijo;

}