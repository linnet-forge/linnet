package LINNET.webcore.model;

import java.math.BigDecimal;

public class Account {
    private BigDecimal id;
    private String username;
    private String password;
    private String email;

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
