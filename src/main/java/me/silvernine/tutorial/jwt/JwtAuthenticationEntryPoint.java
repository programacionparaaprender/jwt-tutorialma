package me.silvernine.tutorial.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
   @Override
   public void commence(HttpServletRequest request,
                        HttpServletResponse response,
                        AuthenticationException authException) throws IOException {
      // ìœ íš¨í•œ ìž�ê²©ì¦�ëª…ì�„ ì œê³µí•˜ì§€ ì•Šê³  ì ‘ê·¼í•˜ë ¤ í• ë•Œ 401
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
   }
}
