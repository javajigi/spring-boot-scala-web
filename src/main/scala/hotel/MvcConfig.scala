package hotel

import javax.annotation.Resource

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.context.annotation.Bean

import support.web.LoginUserHandlerMethodArgumentResolver
import support.security.SessionService

@Configuration
class MvcConfig extends WebMvcConfigurerAdapter {
  @Resource(name = "sessionService")
  private var sessionService: SessionService = _

  override def addArgumentResolvers(argumentResolvers: java.util.List[HandlerMethodArgumentResolver]) {
    argumentResolvers.add(loginUserHandlerMethodArgumentResolver())
  }

  @Bean
  def loginUserHandlerMethodArgumentResolver() = {
    new LoginUserHandlerMethodArgumentResolver(sessionService)
  }
}