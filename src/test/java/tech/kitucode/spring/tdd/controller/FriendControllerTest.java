package tech.kitucode.spring.tdd.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import tech.kitucode.spring.tdd.domain.Friend;
import tech.kitucode.spring.tdd.domain.enumerations.Gender;
import tech.kitucode.spring.tdd.service.FriendService;

import java.util.Arrays;
import java.util.List;


@WebMvcTest(FriendController.class)
public class FriendControllerTest {
    @MockBean
    FriendService friendService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testFindAll() throws Exception{
        Friend friend = new Friend("Brian", "brian@gmail.com", "254712345678", Gender.MALE);
        List<Friend> friends = Arrays.asList(friend);

        Mockito.when(friendService.findAll()).thenReturn(friends);

        mockMvc.perform(get("/api/friends"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Brian")));
    }

}
