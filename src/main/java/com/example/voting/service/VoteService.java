package com.example.voting.service;

import com.example.voting.repository.JdbcRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VoteService {

    private final JdbcRepository jdbcRepository;

    public VoteService(JdbcRepository jdbcRepository) {
        this.jdbcRepository = jdbcRepository;
    }

    public void saveVoteIfNotExists(UUID userUuid, boolean voteValue){
        if(!jdbcRepository.isUserExist(userUuid)){
            jdbcRepository.saveVote(userUuid, voteValue);
        }
    }
}
