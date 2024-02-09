package me.silvernine.tutorial.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.silvernine.tutorial.dto.UserDto;
import me.silvernine.tutorial.dto.request.TarjetaDtoRequest;
import me.silvernine.tutorial.entity.TarjetaCredito;
import me.silvernine.tutorial.service.TarjetaService;
import me.silvernine.tutorial.service.UserService;

@RestController
@RequestMapping("/api/tarjeta")
public class TarjetaController {
	private final TarjetaService tarjetaService;

    public TarjetaController(TarjetaService _tarjetaService) {
        this.tarjetaService = _tarjetaService;
    }

    @PostMapping("/")
    public ResponseEntity<TarjetaCredito> save(@Valid @RequestBody TarjetaDtoRequest tarjetaDto) {
        
    	return ResponseEntity.ok(tarjetaService.save(tarjetaDto));
    }
    
    @GetMapping("/")
    public ResponseEntity<List<TarjetaCredito>> findAll() {
        return ResponseEntity.ok(tarjetaService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TarjetaCredito> findById(Long id) {
        return ResponseEntity.ok(tarjetaService.findById(id));
    }

}
