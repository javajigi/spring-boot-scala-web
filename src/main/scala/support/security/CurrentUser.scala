package support.security

import hotel.domain.User
import org.springframework.security.core.authority.AuthorityUtils

class CurrentUser(user: User) 
  extends org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList("USER")) {

}