package support.test

import hotel.MyConfig
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.{IntegrationTest, SpringApplicationConfiguration}
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[MyConfig]))
@WebAppConfiguration
@IntegrationTest(Array("server.port:0"))
trait AbstractIntegrationTest {
  @Value("${local.server.port}")
  var port: Int = _

  def baseUrl = "http://localhost:" + port
}
