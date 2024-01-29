package com.example.example4sem6_rikky_and_morty_rest.controller;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import com.example.example4sem6_rikky_and_morty_rest.service.ServiceApi;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
@AllArgsConstructor
public class WebController {
    private ServiceApi serviceApi;

    @GetMapping("/")
    public String getAllCharacters(Model model)
    {
        Characters allCharacters = serviceApi.getAllCharacters();
        ResponseEntity caracters = new ResponseEntity<>(allCharacters, HttpStatus.OK);
        model.addAttribute("characters", caracters.getBody());
        return "index";
    }


}
