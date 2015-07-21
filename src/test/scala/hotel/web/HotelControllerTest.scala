package hotel.web

import hotel.MyConfig
import hotel.domain.{User, UserRepository}
import org.junit.runner.RunWith
import org.junit.{Before, Test}
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.boot.test.{IntegrationTest, SpringApplicationConfiguration, TestRestTemplate}
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.util.LinkedMultiValueMap

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
    val form = new LinkedMultiValueMap[String, String]();
    form.add("username", "user1");
    form.add("password", "password");

    val response = restTemplate.postForLocation("http://localhost:" + port + "/login", form)
    println(response)
  }

  @Test
  def testGetHotels() {
//    val response = restTemplate.getForEntity("http://localhost:" + port + "/hotels", classOf[String])
//    assertThat(response.getStatusCode, is(HttpStatus.OK))
//    println(response.getBody)
  }
}