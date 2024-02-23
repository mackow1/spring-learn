package pl.kowalczyk.maciej.spring.learn.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import pl.kowalczyk.maciej.spring.learn.service.ApartmentService;
import pl.kowalczyk.maciej.spring.learn.service.AuthorService;
import pl.kowalczyk.maciej.spring.learn.service.CarService;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ApartmentControllerTestingWebMvcTest {

    private static final String APARTMENTS_URL = "/apartments";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApartmentService apartmentService;

    @MockBean
    private AuthorService authorService;

    @MockBean
    private CarService carService;

    @Test
    void create() throws Exception {
        // given
        ApartmentModel apartmentModel = new ApartmentModel();
        apartmentModel.setName("MockTestApartment");
        apartmentModel.setPrice(12345);

        ObjectMapper objectMapper = new ObjectMapper();

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        Map<String, String> fieldMap = objectMapper.convertValue(apartmentModel, new TypeReference<Map<String, String>>() {});
        multiValueMap.setAll(fieldMap);

        // when
        Mockito.when(apartmentService.create(apartmentModel)).thenReturn(apartmentModel);

        this.mockMvc.perform(post(APARTMENTS_URL).params(multiValueMap))
                .andExpect(status().is3xxRedirection());
        // then

    }
}
