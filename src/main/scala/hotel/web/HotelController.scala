package hotel.web

import org.springframework.security.web.bind.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.stereotype.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import java.lang.Long
import org.springframework.web.bind.annotation.PathVariable

import hotel.domain.HotelRepository
import hotel.domain.Hotel
import hotel.domain.User

import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestMethod
import javax.validation.Valid
import support.security.LoginUserDetails
import support.web.LoginUser
import org.slf4j.LoggerFactory

@Controller
@RequestMapping(Array("/hotels"))
class HotelController @Autowired() (private val hotelRepository: HotelRepository) {
  @RequestMapping(method = Array(RequestMethod.GET))
  def list(model: Model) = {
    val hotels = hotelRepository.findAll()
    model.addAttribute("hotels", hotels)
    "hotels/list"
  }

  @RequestMapping(Array("/edit/{id}"))
  def edit(@PathVariable("id") id: Long, model: Model) = {
    model.addAttribute("hotel", hotelRepository.findOne(id))
    "hotels/edit"
  }

  @RequestMapping(method = Array(RequestMethod.GET), params = Array("form"))
  def createForm(@AuthenticationPrincipal loginUser: LoginUserDetails, model: Model) = {
    println("login user : " + loginUser.getUser)
    
    model.addAttribute("hotel", new Hotel())
    "hotels/create"
  }

  @RequestMapping(method = Array(RequestMethod.POST))
  def create(@Valid hotel: Hotel, bindingResult: BindingResult) = {
    if (bindingResult.hasErrors()) {
      "hotels/create"
    } else {
      hotelRepository.save(hotel)
      "redirect:/hotels"
    }
  }

  @RequestMapping(value = Array("/update"), method = Array(RequestMethod.POST))
  def update(@Valid hotel: Hotel, bindingResult: BindingResult) = {
    if (bindingResult.hasErrors()) {
      "hotels/edit"
    } else {
      hotelRepository.save(hotel)
      "redirect:/hotels"
    }
  }

  @RequestMapping(value = Array("/delete/{id}"))
  def delete(@PathVariable("id") id: Long) = {
    hotelRepository.delete(id)
    "redirect:/hotels"
  }
}