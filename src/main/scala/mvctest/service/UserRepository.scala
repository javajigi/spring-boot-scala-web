package mvctest.service

import java.lang.Long
import mvctest.domain.User
import org.springframework.data.repository.CrudRepository

trait UserRepository extends CrudRepository[User, Long] {
  def findByUsername(username: String): User
}