package fr.crafters.hexagonal.bank.infrastructure.restapi;

import fr.crafters.hexagonal.bank.domain.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1.0/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Long create(@RequestBody CreateAccountRequest request) {
        return accountService.create(request.toCommand());
    }
}

