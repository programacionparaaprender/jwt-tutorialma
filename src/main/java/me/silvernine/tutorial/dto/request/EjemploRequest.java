package me.silvernine.tutorial.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EjemploRequest {
	public static final String NOT_EMPTY = "no puede quedar sin valor";

    @NotEmpty(message = NOT_EMPTY)
    private String name;
}
