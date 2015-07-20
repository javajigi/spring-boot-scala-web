package hotel.domain

import javax.persistence.Id
import javax.persistence.GeneratedValue
import java.lang.Long
import javax.persistence.Entity
import scala.beans.BeanProperty
import org.hibernate.validator.constraints.NotEmpty

object Hotel {
  def apply(n: String, a: String, z: String) = new Hotel(null, n, a, z) 
}

@Entity
class Hotel(identity: Long, n: String, a: String, z: String) {
  @Id 
  @GeneratedValue 
  @BeanProperty
  var id: Long = identity
  
  @BeanProperty
  @NotEmpty
  var name: String = n
  
  @BeanProperty
  @NotEmpty
  var address: String = a
  
  @BeanProperty
  @NotEmpty
  var zip: String = z
  
  def this() = this(null, null, null, null)
}