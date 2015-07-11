package mvctest

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  override def configure(http: HttpSecurity) {
    http
      .authorizeRequests()
          .antMatchers("/hotels").authenticated()
          .anyRequest().permitAll()
          .and()
      .formLogin()
          .loginPage("/login/form")
          .loginProcessingUrl("/login")
          .usernameParameter("username")
          .passwordParameter("password")
          .permitAll()
          .and()
      .logout()
          .permitAll();
  }
  
  @Autowired
  def configureGlobal(auth: AuthenticationManagerBuilder) {
    auth
      .inMemoryAuthentication()
          .withUser("user").password("password").roles("USER");
  }
}