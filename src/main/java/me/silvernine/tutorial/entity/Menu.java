package me.silvernine.tutorial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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