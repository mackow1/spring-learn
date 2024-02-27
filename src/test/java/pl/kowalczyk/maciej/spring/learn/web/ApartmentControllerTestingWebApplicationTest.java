package pl.kowalczyk.maciej.spring.learn.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApartmentControllerTestingWebApplicationTest {

    private static final String APARTMENTS_URL = "/apartments";
    private static final String LIST_OF_APARTMENTS_HTML_TEXT = "List of apartments";

    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    private ApartmentService apartmentService;

    @Test
    @WithMockUser
    void createView() throws Exception {
        // given


        // when
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get(APARTMENTS_URL));

        // then
        resultActions
                .andDo(print())
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

//    @Test
//    void read() throws Exception {
//        // given
//        ApartmentModel apartmentModel = new ApartmentModel(); // Set up your model
//        apartmentModel.setId(1L);
//        apartmentModel.setName("TestingWebApplicationApartment");
//        apartmentModel.setPrice(9090);
//
//        given(apartmentService.read(1L)).returns(apartmentModel, );
//
//        // when
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/apartment"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("")));
//
//        // then
//
//    }
}
