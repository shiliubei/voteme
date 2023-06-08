package com.example.voting.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class JdbcRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveVote(UUID userId, boolean voteValue) {
        String sql = "INSERT INTO vote.voting (user_uuid, vote_value) VALUES ( :userUuid, :voteValue)";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userUuid", userId);
        parameters.put("voteValue", voteValue);

        jdbcTemplate.update(sql, parameters);
    }

    public boolean isUserExist(UUID userUuid) {
        String sql = "SELECT EXISTS(SELECT 1 FROM vote.voting WHERE userUuid = :userUuid)";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userUuid", userUuid);

        return jdbcTemplate.queryForObject(sql, parameters, Boolean.class);
    }


}
