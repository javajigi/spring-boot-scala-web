package mvctest

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import mvctest.service.HotelRepository
import mvctest.domain.Hotel

@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[SampleConfig]))
class SampleConfigTest {
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