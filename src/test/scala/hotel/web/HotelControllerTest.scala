package hotel.web

import hotel.MyConfig
import hotel.domain.{User, UserRepository}
import org.hamcrest.CoreMatchers._
import org.junit.Assert._
import org.junit.{Before, Test}
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.boot.test.{IntegrationTest, SpringApplicationConfiguration, TestRestTemplate}
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[MyConfig]))
@WebAppConfiguration
@IntegrationTest(Array("server.port:0"))
class HotelControllerTest {
  @Value("${local.server.port}")
  var port: Int = _

  val restTemplate = new TestRestTemplate

  @Autowired
  var userRepository: UserRepository = _

  @Before
  def setup() {
    val user = new User()
    user.setUsername("user1")
    user.setPassword("pass")
    userRepository.save(user)
    println("saved user : " + user)

//    val uriVariables = Map("username" -> user.getUsername, "password" -> user.getPassword)
//    val response = restTemplate.postForEntity("http://localhost:" + port + "/login", null, classOf[String], uriVariables)
//    println("body : " + response.getBody)
  }

  @Test
  def testGetHotels() {
    val response = restTemplate.getForEntity("http://localhost:" + port + "/hotels", classOf[String])
    assertThat(response.getStatusCode, is(HttpStatus.OK))
    println(response.getBody)
  }
}