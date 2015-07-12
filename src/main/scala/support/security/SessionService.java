package support.security;

import mvctest.domain.User;
import mvctest.service.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("sessionService")
public class SessionService {
	@Autowired
    private UserRepository userRepository;

    public User getLoginUser() {
        if (!isAuthenticated()) {
            return User.guestUser();
        }
        
        User user = userRepository.findByUsername(getAuthenticatedUserName());
        if (user == null) {
            return User.guestUser();
        }
        return user;
    }
    
    public boolean isAuthenticated() {
        return getAuthentication() == null ? false : getAuthentication().isAuthenticated();
    }
    
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    private String getAuthenticatedUserName() {
        return getAuthentication() == null ? null : getAuthentication().getName();
    }
}
