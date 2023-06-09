package com.example.voting.dto;

public class VoteResult {
    private long totalYes;
    private long totalNo;

    public VoteResult(long totalYes, long totalNo) {
        this.totalYes = totalYes;
        this.totalNo = totalNo;
    }

    public long getTotalYes() {
        return totalYes;
    }

    public long getTotalNo() {
        return totalNo;
    }
}
