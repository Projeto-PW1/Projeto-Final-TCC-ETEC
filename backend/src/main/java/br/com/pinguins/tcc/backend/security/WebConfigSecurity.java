package br.com.pinguins.tcc.backend.security;

import br.com.pinguins.tcc.backend.services.ImplementationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {

    private final ImplementationUserDetailsService implementationUserDetailsService;

    @Autowired
    public WebConfigSecurity(ImplementationUserDetailsService implementationUserDetailsService) {
        this.implementationUserDetailsService = implementationUserDetailsService;
    }

    // Configura as solitações de acesso por HTTP
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // ATIVANDO A PROTEÇÃO CONTRA O USER QUE NÃO ESTÁ VALIDADO COM TOKEN
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .disable().authorizeHttpRequests()// Ativação a restrição a URL
                .antMatchers("/index")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/index")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and().
                addFilterBefore(
                        new JWTLoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTApiAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO - Service que irá consultar o user no banco de dados
        auth.userDetailsService(implementationUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder()); // Padrão de codificação de senha para o user
    }
}
