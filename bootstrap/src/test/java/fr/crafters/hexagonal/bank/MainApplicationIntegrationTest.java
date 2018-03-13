package fr.crafters.hexagonal.bank;

import fr.crafters.hexagonal.bank.infrastructure.database.JpaAccountRepository;
import fr.crafters.hexagonal.bank.infrastructure.restapi.AccountController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MainApplicationIntegrationTest {

    @Autowired
    private AccountController accountController;

    @Autowired
    private JpaAccountRepository accountRepository;

    @Test
    public void should_create_an_account_controller() {
        assertThat(accountController).isNotNull();
    }

    @Test
    public void should_create_an_account_repository() {
        assertThat(accountRepository).isNotNull();
    }
}
