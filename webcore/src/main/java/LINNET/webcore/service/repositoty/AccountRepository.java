package LINNET.webcore.service.repositoty;

import LINNET.webcore.model.Account;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository {
    private final JdbcTemplate driver;

    public AccountRepository(JdbcTemplate driver){
        this.driver = driver;
    }

    public boolean checkAdmin(String user, String password){
        return (user.equals("admin") && password.equals("admin"));
    }

    public void createAccount(String username,String password, String email){
        var SQL = "INSERT INTO account (username,password,email) VALUES(?,?,?)";
        driver.update(SQL,username,password,email);
    }

    public List<Account> getAllAccounts(){
        var SQL = "SELECT * FROM account";
        RowMapper<Account> mapper = (r,i)->{
            Account account = new Account();
            account.setId(r.getBigDecimal("id"));
            account.setUsername(r.getString("username"));
            account.setPassword(r.getString("password"));
            account.setEmail(r.getString("email"));
            return account;
        };
        return driver.query(SQL,mapper);
    }

    public Account getAccountByName(String username){
        var SQL = "SELECT * FROM account WHERE username = ?";
        RowMapper<Account> mapper = (r,i)->{
            Account account = new Account();
            account.setId(r.getBigDecimal("id"));
            account.setUsername(r.getString("username"));
            account.setPassword(r.getString("password"));
            account.setEmail(r.getString("email"));
            return account;
        };
        return driver.queryForObject(SQL,mapper,username);
    }

    public Account getLogin(String username,String password) throws EmptyResultDataAccessException {
        var SQL = "SELECT * FROM account WHERE username = ? and password = ?";
        RowMapper<Account> mapper = (r,i)->{
            Account account = new Account();
            account.setId(r.getBigDecimal("id"));
            account.setUsername(r.getString("username"));
            account.setPassword(r.getString("password"));
            account.setEmail(r.getString("email"));
            return account;
        };
        return driver.queryForObject(SQL,mapper,username,password);
    }
}
