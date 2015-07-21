package support.security

import javax.annotation.Resource

import org.springframework.stereotype.Service
import org.springframework.security.core.userdetails.UserDetailsService

import hotel.domain.User
import hotel.domain.UserRepository

@Service("userDetailsService")
class CurrentUserDetailsService extends UserDetailsService {
  @Resource(name="userRepository")
  private var userRepository: UserRepository = _
  
  def loadUserByUsername(username: String) = {
    val user = userRepository.findByUsername(username)
    new LoginUserDetails(user)
  }
}