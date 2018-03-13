package fr.crafters.hexagonal.bank.acceptance.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.crafters.hexagonal.bank.AutoConfigureTest;
import fr.crafters.hexagonal.bank.infrastructure.database.JpaAccountRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureTest
public class AccountStepDefs {

    private RequestBuilder request;
    private Long createdId;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JpaAccountRepository accountRepository;

    @Given("^([^\"]*) born on ([^\"]*)$")
    public void given_a_client_bon_on_date(String name, Date birthday) {
        request = post("/v1.0/accounts")
                .contentType(APPLICATION_JSON)
                .content(String.format("{ \"name\": \"%s\", \"birthday\": %d }", name, birthday.getTime()));
    }

    @When("^he opens a bank account$")
    public void when_he_opens_a_bank_account() throws Exception {
        createdId = Long.valueOf(
                mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andReturn()
                        .getResponse()
                        .getContentAsString()
        );
    }

    @Then("^the initial balance is (\\d+\\.\\d+) EUR$")
    public void then_the_initial_balance_is_(double expectedBalance) {
        val created = accountRepository.findOne(createdId);
        assertThat(created.getBalance()).isEqualTo(expectedBalance);
    }
}