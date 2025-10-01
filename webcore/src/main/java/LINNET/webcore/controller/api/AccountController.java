package LINNET.webcore.controller.api;

import LINNET.webcore.model.Account;
import LINNET.webcore.service.repositoty.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @GetMapping("/findAllAccounts")
    public List<Account> findAllAccounts(){
        return accountRepository.getAllAccounts();
    }

    @PostMapping("/createAccount")
    public void createAccount(String username, String password, String email){
        accountRepository.createAccount(username,password,email);
    }

    @GetMapping("/findAccount")
    public Account findAccount(String username){
        return accountRepository.getAccountByName(username);
    }
}
