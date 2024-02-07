package me.silvernine.tutorial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import me.silvernine.tutorial.entity.Menu;


public interface MenuRepository extends JpaRepository<Menu, Long> {
	   List<Menu> findAll();

	   //@EntityGraph(attributePaths = "authorities")
	   //Optional<Menu> findOneWithAuthoritiesByUsername(String username);
}
