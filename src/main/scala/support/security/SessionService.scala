package support.security

import hotel.domain.User
import hotel.domain.UserRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AnonymousAuthenticationToken

@Service("sessionService")
class SessionService(@Autowired userRepository: UserRepository) {
  def getLoginUser(): User = {
    if (!isAuthenticated()) {
      return User.guestUser
    }
    
    val user = userRepository.findByUsername(getAuthenticatedUserName())
    if (user == null) return User.guestUser
    
    user
  }
  
  def isAuthenticated() = {
    getAuthentication() match {
      case Some(a) => a.isAuthenticated()
      case None => false
    }
  }
  
  def getAuthentication() = {
    Option(SecurityContextHolder.getContext().getAuthentication())
  }
  
  def getAuthenticatedUserName(): String = {
    getAuthentication() match {
      case Some(a) => a.getName
      case None => null
    }   
  }
  
  def this() = this(null)
}