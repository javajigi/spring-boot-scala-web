package mvctest.domain

import scala.beans.BeanProperty

class Authentication {
  @BeanProperty
  var username: String = _
  
  @BeanProperty
  var password: String = _
}