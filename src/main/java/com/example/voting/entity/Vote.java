package com.example.voting.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "voting", schema = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_uuid")
    private UUID userUuid;

    @Column(name = "vote_value")
    private boolean voteValue;

    public Vote() {
    }

    public Vote(UUID userUuid, boolean voteValue) {
        this.userUuid = userUuid;
        this.voteValue = voteValue;
    }

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public boolean getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(boolean voteValue) {
        this.voteValue = voteValue;
    }
}
