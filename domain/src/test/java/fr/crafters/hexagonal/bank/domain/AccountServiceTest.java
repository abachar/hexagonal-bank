package fr.crafters.hexagonal.bank.domain;

import fr.crafters.hexagonal.bank.domain.entities.Account;
import lombok.val;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class AccountServiceTest {
    private final AccountRepository accountRepository = mock(AccountRepository.class);
    private final AccountService service = new AccountService(accountRepository);

    @Test
    public void should_create_new_account_with_new_id() {
        val argumentCaptor = forClass(Account.class);
        val created = mock(Account.class);
        doReturn(created).when(accountRepository).save(argumentCaptor.capture());
        doReturn(1234L).when(created).getId();

        // Given
        val birthday = new Date();
        val command = new CreateAccountCommand("abachar", birthday);

        // When
        val createdId = service.create(command);

        // Then
        assertThat(createdId).isEqualTo(1234L);

        val account = argumentCaptor.getValue();
        assertThat(account.getId()).isNull();
        assertThat(account.getName()).isEqualTo("abachar");
        assertThat(account.getBirthday()).isEqualTo(birthday);
    }
}