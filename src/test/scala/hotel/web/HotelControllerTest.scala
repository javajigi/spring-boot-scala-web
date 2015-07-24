package hotel.web

import hotel.MyConfig
import org.hamcrest.CoreMatchers._
import org.junit.Assert._
import org.junit.runner.RunWith
import org.junit.{Before, Test}
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.{IntegrationTest, SpringApplicationConfiguration, TestRestTemplate}
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.util.LinkedMultiValueMap
import support.test.AbstractIntegrationTest

@RunWith(classOf[SpringJUnit4ClassRunner])
class HotelControllerTest extends AbstractIntegrationTest {
  val restTemplate = new TestRestTemplate

  @Before
  def setup() {
    val form = new LinkedMultiValueMap[String, String]();
    form.add("username", "user1");
    form.add("password", "password");

    val response = restTemplate.postForLocation(baseUrl +  "/login", form)
    println(response)
  }

  @Test
  def testGetHotels() {
    val response = restTemplate.getForEntity(baseUrl + "/hotels", classOf[String])
    assertThat(response.getStatusCode, is(HttpStatus.OK))
    println(response.getBody)
  }
}