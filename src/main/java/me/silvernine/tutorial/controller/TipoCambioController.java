package me.silvernine.tutorial.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

import me.silvernine.tutorial.dto.request.TipoCambioRequest;
import me.silvernine.tutorial.dto.response.TipoCambioResponse;
import me.silvernine.tutorial.service.TipoCambioService;


@RestController
@RequestMapping("/tipocambio")
public class TipoCambioController {
	
    private final TipoCambioService tipoCambioService;

    public TipoCambioController(TipoCambioService tipoCambioService) {
        this.tipoCambioService = tipoCambioService;
    }
    
    //@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    //@PostMapping("/cambio")
    @GetMapping(path = "/cambio/{monedaorigen}/{monedadestino}/{monto}") 
    //bloqueo en amazon ec2 por eso se comenta
    //@PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<TipoCambioResponse> getCambio(@PathVariable String monedaorigen, @PathVariable String monedadestino, @PathVariable String monto) {
    	TipoCambioRequest request = new TipoCambioRequest();
    	request.setMonedaorigen(monedaorigen);
    	request.setMonedadestino(monedadestino);
    	request.setMonto(monto);
    	TipoCambioResponse tipoCambioResponse;
    	
    	tipoCambioResponse = tipoCambioService.getCambio(request);
        return ResponseEntity.ok(tipoCambioResponse);
    }
    
    //@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    //@PostMapping("/cambio")
    @PostMapping(path = "/cambio", consumes = "application/json", produces = "application/json") 
    //@PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<TipoCambioResponse> postCambio(@Valid @RequestBody TipoCambioRequest request) {
    	TipoCambioResponse tipoCambioResponse;
    	tipoCambioResponse = tipoCambioService.getCambio(request);
        return ResponseEntity.ok(tipoCambioResponse);
    }
}
