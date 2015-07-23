package hotel.domain

import hotel.MyConfig
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[MyConfig]))
class HotelRepositoryTest {
  @Autowired
  var hotelRepository: HotelRepository = _

  @Test
  def crud(): Unit = {
    val hotel = Hotel("hotel name", "hotel address", "215830")
    hotelRepository.save(hotel)
    val persisted = hotelRepository.findOne(hotel.getId)
    println(persisted)
  }
}
