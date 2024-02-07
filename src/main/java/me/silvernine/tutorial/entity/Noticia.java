package me.silvernine.tutorial.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
