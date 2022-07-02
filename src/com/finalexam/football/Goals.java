package com.finalexam.football;

public class Goals {
    private int receivedGoals;
    private int firedGoals;

    public Goals(int receivedGoals, int firedGoals) {
        this.receivedGoals = receivedGoals;
        this.firedGoals = firedGoals;
    }

    public int getReceivedGoals() {
        return receivedGoals;
    }

    public void setReceivedGoals(int receivedGoals) {
        this.receivedGoals = receivedGoals;
    }

    public int getFiredGoals() {
        return firedGoals;
    }

    public void setFiredGoals(int firedGoals) {
        this.firedGoals = firedGoals;
    }
}
