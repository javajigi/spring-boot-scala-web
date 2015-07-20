package hotel.domain

import java.lang.Long

import org.springframework.data.repository.CrudRepository

import hotel.domain.User._

trait UserRepository extends CrudRepository[User, Long] {
  def findByUsername(username: String): User
}