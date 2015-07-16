package support.web

import org.springframework.core.ErrorCoded

class LoginRequiredException extends Exception with ErrorCoded {
    override def getErrorCode() = {
       "exception.login.required"
    }
}