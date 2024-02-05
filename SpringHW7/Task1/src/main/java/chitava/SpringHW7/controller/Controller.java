package chitava.SpringHW7.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;


@org.springframework.stereotype.Controller
@AllArgsConstructor
public class Controller {
    UserDetailsManager manager;

    @GetMapping("/")
    public String login(Authentication auth) {
        Collection<? extends GrantedAuthority> roles = auth.getAuthorities();
        for (GrantedAuthority g : roles) {
            if (g.getAuthority().equals("ROLE_ADMIN")) {
                return "/privet";
            } else {
                return "/public";
            }
        }return "/";
    }

    @GetMapping("/privet")
    public String getPrivet(Authentication auth){
        Collection<? extends GrantedAuthority> roles = auth.getAuthorities();
        for (GrantedAuthority g : roles) {
            if (!g.getAuthority().equals("ROLE_ADMIN")) {
                return "redirect:/";
            } else {
                return "/privet";
            }
        }return "/";
    }
}


