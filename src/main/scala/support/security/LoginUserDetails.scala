package support.security

import hotel.domain.User
import org.springframework.security.core.authority.AuthorityUtils

class LoginUserDetails(u: User)
  extends org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), AuthorityUtils.createAuthorityList("USER")) {
  val user = u
  def getUser = user
}