package br.com.pinguins.tcc.backend.security;

import br.com.pinguins.tcc.backend.ApplicationContextLoad;
import br.com.pinguins.tcc.backend.entities.Usuario;
import br.com.pinguins.tcc.backend.repositories.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Service
@Component
public class JWTTokenAuthenticationService {

    // Tempo de expiração do token - 2 dias
    private static final long EXPIRATION_TIME = 172800000;

    // Senha unica para compor a autenticação e ajudar na segurança
    private static final String SECRET = "SenhaSecreta";

    // Prefixo padrão de token
    private static final String TOKEN_PREFIX = "Bearer"; // Bearer k8ak8ak8sa85akda043fakfDFSFSD

    private static final String HEADER_STRING = "Authorization";

    /* Gerando token de autenticação e adicionando ao cabeçalho e responsta HTTP */

    public void addAuthentication(HttpServletResponse response, String username) throws IOException {

        String JWT = Jwts
                .builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();

        // Juntando o token com o prefixo
        String token = TOKEN_PREFIX + " " + JWT;

        // add o cabeçalho http
        response.addHeader(HEADER_STRING, token);

        // escreve o token como resposta do corpo http - JSON
        response.getWriter().write("{\"Authorization\": \""+ token+"\"}");
    }

    /* Retorna o usuario validado(token)*/

    public Authentication getAuthentication(HttpServletRequest request) {

        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            // Faz a validação do token do user;
            String user = Jwts.parser().setSigningKey(SECRET)// Bearer.k8ak8ak8sa85akda043fakfDFSFSD
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody().getSubject();
            if (user != null) {
                Usuario usuario = ApplicationContextLoad
                        .getApplicationContext()
                        .getBean(UsuarioRepository.class)
                        .findUsuarioByLogin(user);
                if (usuario != null) {
                    return  new UsernamePasswordAuthenticationToken(
                            usuario.getLogin(), usuario.getSenha(), usuario.getAuthorities());
                }
            }
        }
        return null; // Não autorizado
    }
}
