package hotel.web

import hotel.MyConfig
import org.hamcrest.CoreMatchers._
import org.junit.Assert._
import org.junit.{Test, Before}
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.{TestRestTemplate, IntegrationTest, SpringApplicationConfiguration}
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.util.LinkedMultiValueMap
import support.test.AbstractIntegrationTest

class LoginControllerTest extends AbstractIntegrationTest {
  val restTemplate = new TestRestTemplate

  @Before
  def setup() {
    val form = new LinkedMultiValueMap[String, String]();
    form.add("username", "user1");
    form.add("password", "password");

    val response = restTemplate.postForLocation(baseUrl + "/login", form)
    println(response)
  }

  @Test
  def testGetHotels() {
    val response = restTemplate.getForEntity(baseUrl + "/hotels", classOf[String])
    assertThat(response.getStatusCode, is(HttpStatus.OK))
    println(response.getBody)
  }
}
