package me.silvernine.tutorial.entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "`autor`")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

   @Id
   @Column(name = "autor_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long autorId;

   @Column(name = "nombre", length = 100, unique = false)
   private String nombre;

   @Column(name = "apellido", length = 100)
   private String apellido;
   
   @OneToMany
   @JoinColumn(name = "noticia_id")
   private Set<Noticia> noticias;

}