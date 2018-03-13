package fr.crafters.hexagonal.bank.domain;

import fr.crafters.hexagonal.bank.domain.entities.Account;

public interface AccountRepository {
    Account save(Account account);
}
