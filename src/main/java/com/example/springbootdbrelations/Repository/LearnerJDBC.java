package com.example.springbootdbrelations.Repository;

import com.example.springbootdbrelations.Entity.Learner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

@Repository
public class LearnerJDBC {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Learner> getALLLearner() {
        String getAllLearnerQuery = "SELECT * FROM Learner";
        return jdbcTemplate.query(getAllLearnerQuery, new BeanPropertyRowMapper<Learner>(Learner.class));
    }

    public int updateLearner(Learner learner) {
        String updateLearnerQuery = "Update Learner SET first_name = ?, last_name = ?, email = ?, password = ?, course = ? "+" WHERE id = ?";
        return jdbcTemplate.update(updateLearnerQuery, new Object[]{learner.getFirst_name(), learner.getLast_name(), learner.getEmail(), learner.getPassword(), learner.getCourse()});
    }
}
