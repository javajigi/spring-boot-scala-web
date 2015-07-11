package mvctest.web

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import mvctest.domain.Authentication

@Controller
class LoginController {
  @RequestMapping(Array("login/form"))
  def loginForm(model: Model) = {
    model.addAttribute("authentication", new Authentication)
    "users/login"
  }
}