package com.example.voting.controller;

import com.example.voting.dto.VoteDto;
import com.example.voting.entity.Vote;
import com.example.voting.jpaRepository.VoteRepository;
import com.example.voting.repository.JdbcRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/main")
public class MainController {

    private final JdbcRepository jdbcRepository;
    private final VoteRepository voteRepository;

    public MainController(JdbcRepository jdbcRepository, VoteRepository voteRepository) {
        this.jdbcRepository = jdbcRepository;
        this.voteRepository = voteRepository;
    }

    @GetMapping("/echo/{message}")
    public String echo (@PathVariable String message){
        return message;
    }


    @PostMapping("/vote")
    public ResponseEntity<String> vote (@RequestBody VoteDto voteDto) {
        boolean voteValue = voteDto.getVoteValue().equalsIgnoreCase("YES");

        jdbcRepository.saveVote(voteDto.getUserUuid(), voteValue);
        Vote vote = new Vote();
        vote.setUserUuid(voteDto.getUserUuid());
        vote.setVoteValue(voteValue);

//        voteRepository.save(vote);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
