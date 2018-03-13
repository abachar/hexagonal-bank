package fr.crafters.hexagonal.bank.infrastructure.database;

import fr.crafters.hexagonal.bank.domain.AccountRepository;
import fr.crafters.hexagonal.bank.domain.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAccountRepository extends AccountRepository, JpaRepository<Account, Long> {
}
