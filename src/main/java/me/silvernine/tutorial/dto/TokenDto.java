package me.silvernine.tutorial.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {

    private String token;
    
    private Integer tokenValidityInHours;
    
    private Integer tokenValidityInDays;
}
