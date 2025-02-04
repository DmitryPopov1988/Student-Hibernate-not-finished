package rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Order(ResourceServerConfig.MINUS_TWENTY)
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

  public static final int MINUS_TWENTY = -20;

  @Autowired
  private CustomUserDetails customUserDetails;

  @Override
  protected void configure(final HttpSecurity http) throws
      Exception {
    http
        .csrf()
        .disable()
        .requestMatchers()
        .antMatchers("/login", "/oauth/authorize", "/exit")
        .and()
        .authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .and()
        .logout();
  }

  @Override
  protected void configure(final AuthenticationManagerBuilder auth)
      throws Exception {
    auth
        .userDetailsService(customUserDetails);
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
