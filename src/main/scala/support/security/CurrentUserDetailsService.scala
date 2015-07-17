package support.security

import javax.annotation.Resource

import org.springframework.stereotype.Service
import org.springframework.security.core.userdetails.UserDetailsService

import mvctest.domain.User
import mvctest.service.UserRepository

@Service("userDetailsService")
class CurrentUserDetailsService extends UserDetailsService {
  @Resource(name="userRepository")
  private var userRepository: UserRepository = _
  
  def loadUserByUsername(username: String) = {
    val user = userRepository.findByUsername(username)
    new CurrentUser(user)
  }
}