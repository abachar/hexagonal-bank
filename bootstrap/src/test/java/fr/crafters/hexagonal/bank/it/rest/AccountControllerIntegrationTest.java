package fr.crafters.hexagonal.bank.it.rest;

import fr.crafters.hexagonal.bank.AutoConfigureTest;
import fr.crafters.hexagonal.bank.infrastructure.database.JpaAccountRepository;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureTest
@RunWith(SpringRunner.class)
public class AccountControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JpaAccountRepository accountRepository;

    @Test
    public void should_convert_request_to_command_and_call_service() throws Exception {
        // Given
        val request = post("/v1.0/accounts")
                .contentType(APPLICATION_JSON)
                .content("{ \"name\": \"abachar\", \"birthday\": 1518641634610 }");
        // When
        val createdId = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        // Then
        val created = accountRepository.findOne(Long.valueOf(createdId));
        assertThat(created.getName()).isEqualTo("abachar");
        assertThat(created.getBirthday()).isEqualToIgnoringHours(new Date(1518641634610L));
    }
}
