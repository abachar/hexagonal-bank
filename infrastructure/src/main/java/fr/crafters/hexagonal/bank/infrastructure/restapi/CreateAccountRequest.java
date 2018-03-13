package fr.crafters.hexagonal.bank.infrastructure.restapi;

import fr.crafters.hexagonal.bank.domain.CreateAccountCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class CreateAccountRequest {
    private String name;
    private Date birthday;

    public CreateAccountCommand toCommand() {
        return new CreateAccountCommand(name, birthday);
    }
}
