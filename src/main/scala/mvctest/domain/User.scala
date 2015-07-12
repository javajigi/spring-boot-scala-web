package mvctest.domain

import javax.persistence.Id
import javax.persistence.GeneratedValue
import java.lang.Long
import javax.persistence.Entity
import scala.beans.BeanProperty

@Entity
class User {
  @Id 
  @GeneratedValue 
  @BeanProperty
  var id: Long = _
  
  @BeanProperty
  var username: String = _
  
  @BeanProperty
  var password: String = _
}