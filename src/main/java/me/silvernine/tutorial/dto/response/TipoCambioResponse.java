package me.silvernine.tutorial.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoCambioResponse {
   private String moneda_origen;
   private String moneda_destino;
   private double monto;
   private double tipo_cambio;
}