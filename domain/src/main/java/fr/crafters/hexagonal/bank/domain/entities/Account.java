package fr.crafters.hexagonal.bank.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@NoArgsConstructor
public class Account {

    private Long id;
    private String name;
    private Date birthday;

    public Account(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Double getBalance() {
        return 0d;
    }
}
