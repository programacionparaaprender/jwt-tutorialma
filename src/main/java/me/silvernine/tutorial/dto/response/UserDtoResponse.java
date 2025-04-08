package me.silvernine.tutorial.dto.response;

import java.util.Set;
import java.util.stream.Collectors;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.silvernine.tutorial.dto.AuthorityDto;
import me.silvernine.tutorial.dto.UserDto;
import me.silvernine.tutorial.entity.User;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoResponse {
		private Long userId;
		@NotNull
	   @Size(min = 3, max = 50)
	   private String username;

	   @NotNull
	   @Size(min = 10, max = 32)
	   @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	   private String email;

	   private Set<AuthorityDto> authorityDtoSet;

	   public static UserDtoResponse from(User user) {
	      if(user == null) return null;

	      return UserDtoResponse.builder()
	              .userId(user.getUserId())
	    		  .username(user.getUsername())
	              .email(user.getEmail())
	              .authorityDtoSet(user.getAuthorities().stream()
	                      .map(authority -> AuthorityDto.builder().authorityName(authority.getAuthorityName()).build())
	                      .collect(Collectors.toSet()))
	              .build();
	   }
}
