package LINNET.webcore.service.repositoty;

import LINNET.webcore.model.Repo;
import jakarta.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepoRepository {
    private HttpSession session;
    private final JdbcTemplate driver;

    public RepoRepository(JdbcTemplate driver) {
        this.driver = driver;
    }

    public boolean checkAdmin(String user, String password){
        return (user.equals("admin") && password.equals("admin"));
    }

    public void createRepo(String name, String user){
        var SQL = "INSERT INTO repo (name, username) VALUES (?, ?)";
        driver.update(SQL, name, user);
    }

    public int getRepo(){
        var SQL = "SELECT * FROM repo";
        RowMapper<Repo> mapper = (r,i)->{
            Repo repo = new Repo();
            repo.setName(r.getString("name"));
            repo.setUsername(r.getString("username"));
            return repo;
        };
        return driver.update(SQL,mapper );
    }

}
