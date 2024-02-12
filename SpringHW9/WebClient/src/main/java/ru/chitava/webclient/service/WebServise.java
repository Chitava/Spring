package ru.chitava.webclient.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.chitava.webclient.model.Student;


import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class WebServise {

    private RestTemplate template = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();
    private static final String allStudents = "http://localhost:4001/server/all";
    private static final String delStudent =  "http://localhost:4001/server/del";
    private static final String adStudent =   "http://localhost:4001/server/add";

    public Student[] getAllstudents() {
        headers.setAccept(List.of(APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Student[]> responce = template.exchange(allStudents, HttpMethod.GET, entity, Student[].class);
        return responce.getBody();
    }

    public ResponseEntity addStudent(Student student) {
        HttpEntity<Student> request = new HttpEntity<>(student);
        ResponseEntity<String> as = template.exchange(adStudent, HttpMethod.POST, request, String.class);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    public ResponseEntity delStudent(Long id) {
        HttpEntity<Long> request = new HttpEntity<>(id);
        ResponseEntity<String> as = template.exchange(delStudent, HttpMethod.DELETE, request, String.class);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

