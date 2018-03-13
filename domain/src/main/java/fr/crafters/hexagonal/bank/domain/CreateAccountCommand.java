package fr.crafters.hexagonal.bank.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class CreateAccountCommand {
    private String name;
    private Date birthday;
}
