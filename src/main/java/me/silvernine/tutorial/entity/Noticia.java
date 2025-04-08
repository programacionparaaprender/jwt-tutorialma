package me.silvernine.tutorial.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
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
@Table(name = "`noticia`")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Noticia {

   @Id
   @Column(name = "noticia_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long noticiaId;

   @Column(name = "titulo", length = 100, unique = false)
   private String titulo;

   @Column(name = "descripcion", length = 200)
   private String descripcion;
   
   @Column(name = "contenido", length = 200)
   private String contenido;
   
   @Column(name = "fecha")
   private Date fecha;
   
   @Column(name = "autor_id")
   private int autorId;

   //@OneToOne(mappedBy = "address")
   //@JoinColumn(name = "autor_id", referencedColumnName = "autor_id")
   //private Set<Autor> autor;
   
}
