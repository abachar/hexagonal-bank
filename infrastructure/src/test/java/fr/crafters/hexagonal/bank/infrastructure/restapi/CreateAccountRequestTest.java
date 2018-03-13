package fr.crafters.hexagonal.bank.infrastructure.restapi;

import lombok.val;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


public class CreateAccountRequestTest {

    @Test
    public void should_convert_request_to_command() {
        // Given
        val birthday = new Date();
        val request = new CreateAccountRequest("abachar", birthday);

        // When
        val command = request.toCommand();

        // Then
        assertThat(command.getName()).isEqualTo("abachar");
        assertThat(command.getBirthday()).isEqualTo(birthday);
    }
}
