package me.silvernine.tutorial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import me.silvernine.tutorial.dto.request.EjemploRequest;
import me.silvernine.tutorial.dto.response.EjemploResponse;
import me.silvernine.tutorial.service.EjemploService;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/ejemplo/v1/ejemplo")
public class EjemploController {
	@Autowired
	private EjemploService ejemploService;
	
	
	
	@GetMapping("flux")
    public Flux<EjemploResponse> indexFluxGet() {
        String port = "8080";
        String username = "sa";
        return Flux.just(this.ejemploService.get("puerto: " + port + " username: " + username));
    }
	
	
	@GetMapping("fluxMono")
    public Mono<EjemploResponse> indexGetFlux() {
    	String port="8080";
		String username="sa";
	
    	return Mono.justOrEmpty(this.ejemploService.get("puerto: " + port + " username: " + username));
    }
	

    @GetMapping("flux/{id}")
    public Flux<EjemploResponse> indexFluxGetData(@PathVariable("id") String id) {
        return Flux.just(this.ejemploService.get(id));
    }

    @PostMapping("flux")
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<EjemploResponse> indexFluxPost(@RequestBody EjemploRequest request) {
        return Flux.just(this.ejemploService.put(request.getName()));
    }
    
    
	
	
    @GetMapping
    public Mono<EjemploResponse> indexGet() {
    	String port="8080";
		String username="sa";
    	return Mono.justOrEmpty(this.ejemploService.get("puerto: " + port + " username: " + username));
    }
    
    
    

    @GetMapping("/{id}")
    public Mono<EjemploResponse> indexGetData(@PathVariable("id") String id) {
    	return Mono.justOrEmpty(this.ejemploService.get(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<EjemploResponse> indexPost(@RequestBody EjemploRequest request) {
        return Mono.justOrEmpty(this.ejemploService.put(request.getName()));
    }
}
