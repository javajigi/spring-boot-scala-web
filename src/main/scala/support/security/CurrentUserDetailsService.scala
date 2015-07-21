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
    println("username : " + username)
    val user = userRepository.findByUsername(username)
    if (user == null) new LoginUserDetails(User.guestUser) else new LoginUserDetails(user)
  }
}