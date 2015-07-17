package support.web

import javax.annotation.Resource
import org.springframework.core.MethodParameter
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import support.security.SessionService

import mvctest.domain.User

import org.springframework.beans.factory.annotation.Autowired

class LoginUserHandlerMethodArgumentResolver 
  (@Autowired private val sessionService: SessionService)
  extends HandlerMethodArgumentResolver {
  
  override def supportsParameter(parameter: MethodParameter) = {
    parameter.hasParameterAnnotation(classOf[LoginUser])
  }
  
  override def resolveArgument(parameter: MethodParameter, mavContainer: ModelAndViewContainer, 
      webRequest: NativeWebRequest, binderFactory: WebDataBinderFactory): Object = {
    val loginUserAnnotation = parameter.getParameterAnnotation(classOf[LoginUser])
    val loginUser = sessionService.getLoginUser();

    if (loginUserAnnotation.required && loginUser.isGuest) {
      throw new LoginRequiredException();
    }

    loginUser;
  }
}