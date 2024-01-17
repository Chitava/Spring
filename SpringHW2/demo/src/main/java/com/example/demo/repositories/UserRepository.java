package com.example.demo.repositories;

import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable VALUES (NULL, ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return  user;
    }
//удаление пользователя
    public String deleteById(int id){
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
        return  String.format("Пользователь с id %s удален из базы", id);
    }


//редактирование пользователя
    public User editById(User user){
        String sql = "UPDATE userTable Set firstName = ?, lastName = ? WHERE id = ?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
     return  user;
}
}

