package chitava.SpringHW7.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * Обработчик http запросов
 */

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class Controller {
    /**
     * Конфигуратор прав пользователей
     */
    UserDetailsManager manager;

    /**
     * обработчик запроса главной страницы
     * @param auth Проверка аутентификации
     * @return страница в зависимости от прав пользователя
     */
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


    /**
     * Обработка запроса страницы к которой есть доступ только у пользователя с правами ADMIN
     * @param auth параметры аутентификации
     * @return если права ADMIN то доступ к странице разрешен, если нет прав ADMIN то возвращает на страницу
     * аутентификации
     */
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


