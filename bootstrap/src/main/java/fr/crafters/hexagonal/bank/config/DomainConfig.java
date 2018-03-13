package fr.crafters.hexagonal.bank.config;

import fr.crafters.hexagonal.bank.domain.AccountService;
import fr.crafters.hexagonal.bank.infrastructure.database.JpaAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public AccountService accountService(JpaAccountRepository accountRepository) {
        return new AccountService(accountRepository);
    }
}
