package hotel

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import hotel.domain.HotelRepository
import hotel.domain.Hotel

@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[MyConfig]))
class MyConfigTest {
  @Autowired
  var hotelRepository: HotelRepository = _
  
  @Test
  def test() {
    val hotel = Hotel("hotel name", "hotel address", "215830")
    hotelRepository.save(hotel)
    val persisted = hotelRepository.findOne(hotel.getId)
    println(persisted)
  }
}