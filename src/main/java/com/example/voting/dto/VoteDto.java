package com.example.voting.dto;

import java.util.UUID;


public class VoteDto {
    private UUID userUuid;
    private String voteValue;

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public String getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(String voteValue) {
        this.voteValue = voteValue;
    }
}

