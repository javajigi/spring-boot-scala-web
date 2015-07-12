package support.security

import org.springframework.security.core.userdetails.UserDetailsService
import mvctest.domain.User
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import mvctest.service.UserRepository

@Service("userDetailsService")
class CurrentUserDetailsService extends UserDetailsService {
  @Autowired
  var userRepository: UserRepository = _
  
  def loadUserByUsername(username: String) = {
    val user = userRepository.findByUsername(username)
    new CurrentUser(user)
  }
}