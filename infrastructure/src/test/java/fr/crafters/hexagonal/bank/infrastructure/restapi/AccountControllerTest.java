package fr.crafters.hexagonal.bank.infrastructure.restapi;


import fr.crafters.hexagonal.bank.domain.AccountService;
import fr.crafters.hexagonal.bank.domain.CreateAccountCommand;
import lombok.val;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AccountControllerTest {
    private AccountService accountService = mock(AccountService.class);
    private AccountController controller = new AccountController(accountService);

    @Test
    public void should_convert_request_to_command_and_call_service() {
        // Given
        val request = mock(CreateAccountRequest.class);
        val command = mock(CreateAccountCommand.class);
        doReturn(command).when(request).toCommand();
        doReturn(1234L).when(accountService).create(command);

        // When
        val accountId = controller.create(request);

        // Then
        assertThat(accountId).isEqualTo(1234L);
        verify(accountService, times(1)).create(command);
    }
}
