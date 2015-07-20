package hotel.web

import org.junit.Test
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.Assert._
import org.hamcrest.CoreMatchers._

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.boot.test.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.boot.test.IntegrationTest
import org.springframework.beans.factory.annotation.Value

import hotel.MyConfig

@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[MyConfig]))
@WebAppConfiguration
@IntegrationTest(Array("server.port:0"))
class HotelControllerTest {
  @Value("${local.server.port}")
  var port:Int = _
  
  val restTemplate = new TestRestTemplate
  
  @Before
  def setup() {
    val uriVariables = Map("username" -> "user1", "password" -> "password")
    val response = restTemplate.postForEntity("http://localhost:" + port + "/login", null, classOf[String], uriVariables)
    println(response.getBody)
  }
  
  @Test
  def testGetHotels() {
    val response = restTemplate.getForEntity("http://localhost:" + port + "/hotels", classOf[String])
    assertThat(response.getStatusCode, is(HttpStatus.OK))
    println(response.getBody)
  }
}