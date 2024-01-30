package pl.kowalczyk.maciej.spring.learn.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApartmentControllerTestingWebApplicationTest {

    public static final String URL_TEMPLATE = "/apartments";
    public static final String LIST_OF_APARTMENTS_HTML_TEXT = "List of apartments";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createView() throws Exception {
        // given


        // when
        ResultActions resultActions = this.mockMvc.perform(get(URL_TEMPLATE));

        // then
        resultActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(LIST_OF_APARTMENTS_HTML_TEXT)));

    }
}
