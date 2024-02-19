package com.example.example4sem6_rikky_and_morty_rest.service;
import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
@ConfigurationProperties
public class ServiceApiImpl implements ServiceApi{

    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;
    @Value("${URL_CHARACTER}")
    private  String CHARACTER_API;

    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(CHARACTER_API, HttpMethod.GET,entity, Characters.class);
        System.out.println(entity);
        return responce.getBody();
    }


}
