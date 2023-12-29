package me.silvernine.tutorial.service;

import java.util.Collections;
import java.util.Optional;
import me.silvernine.tutorial.dto.UserDto;
import me.silvernine.tutorial.dto.request.TipoCambioRequest;
import me.silvernine.tutorial.dto.response.TipoCambioResponse;
import me.silvernine.tutorial.entity.Authority;
import me.silvernine.tutorial.entity.TipoCambio;
import me.silvernine.tutorial.entity.User;
import me.silvernine.tutorial.exception.DuplicateMemberException;
import me.silvernine.tutorial.exception.NotFoundMemberException;
import me.silvernine.tutorial.repository.TipoCambioRepository;
import me.silvernine.tutorial.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoCambioService {
    private final TipoCambioRepository tipoCambioRepository;

    public TipoCambioService(TipoCambioRepository tipoCambioRepository) {
        this.tipoCambioRepository = tipoCambioRepository;
    }
    
    @Transactional(readOnly = true)
    public TipoCambioResponse getCambio(TipoCambioRequest request) {
    	String moneda_origen = request.getMonedaorigen();
    	String moneda_destino = request.getMonedadestino();
    	Optional<TipoCambio> tipoCambioOpt;
    	tipoCambioOpt = tipoCambioRepository.findByMonedaorigenAndMonedadestino(moneda_origen, moneda_destino);
    	TipoCambio tipoCambio;
    	TipoCambioResponse tipoCambioResponse;
		tipoCambioResponse = new TipoCambioResponse();
    	try {
    		if(tipoCambioOpt.isPresent()) {
        		tipoCambio = tipoCambioOpt.get();
        		double tipo_cambio = tipoCambio.getCambio();
        		double monto;
        		monto = Double.parseDouble(request.getMonto());
        		double montoFinal;
        		montoFinal = monto * tipo_cambio;
        		tipoCambioResponse.setMoneda_origen(moneda_origen);
        		tipoCambioResponse.setMoneda_destino(moneda_destino);
        		tipoCambioResponse.setMonto(montoFinal);
        		tipoCambioResponse.setTipo_cambio(tipo_cambio);
        	}
    		
    	}catch(Exception ex) {
    		
    	}
    	return tipoCambioResponse;
    }

}
