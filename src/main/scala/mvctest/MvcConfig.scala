package mvctest

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import support.web.LoginUserHandlerMethodArgumentResolver
import support.security.SessionService
import javax.annotation.Resource
import org.springframework.context.annotation.Bean

@Configuration
class MvcConfig extends WebMvcConfigurerAdapter {
  override def addArgumentResolvers(argumentResolvers: java.util.List[HandlerMethodArgumentResolver]) {
    argumentResolvers.add(loginUserHandlerMethodArgumentResolver())
  }
  
  @Bean
  def loginUserHandlerMethodArgumentResolver() = {
    new LoginUserHandlerMethodArgumentResolver()
  }
}