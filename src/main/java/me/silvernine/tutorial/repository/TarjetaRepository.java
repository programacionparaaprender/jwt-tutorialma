package me.silvernine.tutorial.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import me.silvernine.tutorial.entity.TarjetaCredito;

public interface TarjetaRepository extends JpaRepository<TarjetaCredito, Long> {
	List<TarjetaCredito> findAll();
	Optional<TarjetaCredito> findById(Long id);
	boolean existsByNumerotarjeta(String numerotarjeta);    
}
