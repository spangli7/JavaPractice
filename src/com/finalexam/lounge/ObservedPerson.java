package com.finalexam.lounge;

public class ObservedPerson {
    private int allTime;
    boolean inOrOut;

    public ObservedPerson(int allTime, boolean inOrOut) {
        this.allTime = allTime;
        this.inOrOut = inOrOut;
    }

    public int getAllTime() {
        return allTime;
    }

    public void setAllTime(int allTime) {
        this.allTime = allTime;
    }

    public boolean isInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(boolean inOrOut) {
        this.inOrOut = inOrOut;
    }
}
