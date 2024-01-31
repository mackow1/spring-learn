package pl.kowalczyk.maciej.spring.learn.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApartmentControllerTestingWebApplicationTest {

    public static final String APARTMENTS_URL = "/apartments";
    public static final String LIST_OF_APARTMENTS_HTML_TEXT = "List of apartments";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createView() throws Exception {
        // given


        // when
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get(APARTMENTS_URL));

        // then
        resultActions
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString(LIST_OF_APARTMENTS_HTML_TEXT)));

    }

    @Test
    void create() throws Exception {
        // given
        ApartmentModel apartmentModel = new ApartmentModel();
        apartmentModel.setName("Apartament");
        apartmentModel.setPrice(1000);

        ObjectMapper objectMapper = new ObjectMapper();
        String apartmentAsString = objectMapper.writeValueAsString(apartmentModel);

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        Map<String, String> fieldMap = objectMapper.convertValue(apartmentModel, new TypeReference<Map<String, String>>() {});
        multiValueMap.setAll(fieldMap);

        // when
        this.mockMvc.perform(post(APARTMENTS_URL)
                                .params(multiValueMap)
//                                .param("id", ""+apartmentModel.getId())
//                                .param("name", apartmentModel.getName())
//                        .contentType(MediaType.APPLICATION_JSON).content(apartmentAsString)
                )
                .andExpect(status().is3xxRedirection());
                //.andExpect(content().string(containsString(LIST_OF_APARTMENTS_HTML_TEXT)));

        // then

    }
}
