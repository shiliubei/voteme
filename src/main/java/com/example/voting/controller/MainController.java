package com.example.voting.controller;

import com.example.voting.dto.VoteDto;
import com.example.voting.dto.VoteResult;
import com.example.voting.entity.Vote;
import com.example.voting.jpaRepository.VoteRepository;
import com.example.voting.repository.JdbcRepository;
import com.example.voting.service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
public class MainController {

    private final JdbcRepository jdbcRepository;
    private final VoteRepository voteRepository;
    private final VoteService voteService;

    public MainController(JdbcRepository jdbcRepository, VoteRepository voteRepository, VoteService voteService) {
        this.jdbcRepository = jdbcRepository;
        this.voteRepository = voteRepository;
        this.voteService = voteService;
    }

    @PostMapping("/vote")
    public ResponseEntity<String> vote (@RequestBody VoteDto voteDto) {
        boolean voteValue = voteDto.getVoteValue().equalsIgnoreCase("YES");

        voteService.saveVoteIfNotExists(voteDto.getUserUuid(), voteValue);
        Vote vote = new Vote();
        vote.setUserUuid(voteDto.getUserUuid());
        vote.setVoteValue(voteValue);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/stats")
    public ResponseEntity<VoteResult> getVoteStats() {
        long totalYes = jdbcRepository.countByVoteValue(true);
        long totalNo = jdbcRepository.countByVoteValue(false);
        VoteResult voteStats = new VoteResult(totalYes, totalNo);
        return ResponseEntity.ok(voteStats);
    }

}
