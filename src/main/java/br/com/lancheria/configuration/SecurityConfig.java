package br.com.lancheria.configuration;

import br.com.lancheria.model.entity.Permission;
import br.com.lancheria.model.entity.User;
import br.com.lancheria.model.repository.UserRepository;
import br.com.lancheria.vo.AuthUserVO;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.stream.Collectors;

/**
 * Created by Eduardo on 05/02/2018.
        */
@Configuration
@EnableOAuth2Sso
@Profile("!integrationtests")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
              .antMatchers("/login**", "/webjars/**")
              .permitAll()
            .anyRequest()
              .authenticated()
            .and()
              .logout()
              .logoutSuccessUrl("/")
              .permitAll()
            .and()
              .csrf()
              .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserRepository userRepository) {
        return map -> {
            String facebookId = (String) map.get("id");
            User user = userRepository.findByFacebookId(facebookId);
            return new AuthUserVO(user.getFacebookId(), user.getName(), user.getPermissions().stream()
                    .map(Permission::getName).collect(Collectors.toList()));
        };
    }
}
