package ru.maliutin.resourceserver.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Контроллер сервера ресурсов.
 */
@RestController
public class ResourceController {
    /**
     * Получение ответа
     * @return страница аутантификации
     * @throws IOException исключения при обработке файла с изображением.
     */
    @GetMapping("/auth")
    public ResponseEntity<byte[]> getImageCat() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}
