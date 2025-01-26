package com.example.flipkart.OA.models;

public class Buyer extends User{
    private int participationCount;
    private boolean isPreferred;
    public Buyer(String userName) {
        super(userName);
    }

    public int getAuctionsParticipated() {
        return participationCount;
    }

    public void incrementAuctionsParticipated() {
        participationCount++;
    }

    public boolean isPreferred() {
        return isPreferred;
    }

    public void setPreferred(boolean preferred) {
        isPreferred = preferred;
    }
}
