package hotel

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import scala.beans.BeanProperty
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.annotation.Resource

@Configuration
@EnableWebMvcSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Resource(name="userDetailsService")
  var uds: UserDetailsService = _
  
  override def configure(http: HttpSecurity) {
    // http.csrf().disable()

    http
      .authorizeRequests()
          .antMatchers("/favicon.ico").permitAll()
    
    http
      .authorizeRequests()
          //.antMatchers("/hotels").authenticated()
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
          .permitAll()
  }
  
  override def configure(auth: AuthenticationManagerBuilder) {
    auth
      .userDetailsService(uds)
  }
}
