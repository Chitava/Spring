package Chitava.SpringHW5;

import Chitava.SpringHW5.controllers.WebController;
import Chitava.SpringHW5.models.Note;
import Chitava.SpringHW5.models.Status;
import Chitava.SpringHW5.services.NoteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * тестирование контроллера
 */
@WebMvcTest(WebController.class)

public class TestController {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private NoteService service;

    Note firstNote = new Note();

    @BeforeEach
    public void setup() {

        firstNote.setAnnotation("Новая");
        firstNote.setStatus(Status.NOT_STARTED);
        firstNote.setTime("сегодня");
    }

    @Test
    public void testAddShouldReturn400BadRequest() throws Exception {

        String requestBody = objectMapper.writeValueAsString(firstNote);
        mockMvc.perform(post("/").contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andDo(print())
        ;
    }

}
