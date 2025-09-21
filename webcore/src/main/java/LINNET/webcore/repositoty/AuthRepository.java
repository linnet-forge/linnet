package LINNET.webcore.repositoty;


import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class AuthRepository  {
    private DataSource dataSource;
    private final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AuthRepository.class.getName());

    public final String[] ADMIN = {"ADMIN","ADMIN"};
        public boolean checkAdmin(String username, String password){
            return (username.equals(ADMIN[0]) && password.equals(ADMIN[1]));
        }

    private final JdbcTemplate jdbcTemplate;

    public AuthRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void tryConnection(){
        try {
            logger.info("DB connected");
            dataSource = jdbcTemplate.getDataSource();
        }
        catch (Exception e){
            logger.info("ERROR created by DB connection");
        }
    }
}
