package me.silvernine.tutorial.repository;

import me.silvernine.tutorial.entity.TipoCambio;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface TipoCambioRepository extends JpaRepository<TipoCambio, Long> {
   
   List<TipoCambio> findAll();
   
   Optional<TipoCambio> findByMonedaorigenAndMonedadestino(String moneda_origen, String moneda_destino);
}
