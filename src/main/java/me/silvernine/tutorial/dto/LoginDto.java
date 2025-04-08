package me.silvernine.tutorial.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.silvernine.tutorial.entity.User;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

   @NotNull
   @Size(min = 3, max = 50)
   private String username;
   
   @NotNull
   @Size(min = 3, max = 100)
   private String password;
   
   public static LoginDto from(User user) {
	      if(user == null) return null;

	      return LoginDto.builder()
	              .username(user.getUsername())
	              .password(user.getPassword())
	              .build();
	   }
}
