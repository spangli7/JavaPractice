package com.finalexam.lounge;

import java.time.LocalTime;

public class PeopleData {
private LocalTime localTime;
private int personId;
private boolean in;

public PeopleData(LocalTime localTime, int personId, boolean in) {
    this.localTime = localTime;
    this.personId = personId;
    this.in = in;
}

public LocalTime getLocalTime() {
    return localTime;
}

public void setLocalTime(LocalTime localTime) {
    this.localTime = localTime;
}

public int getPersonId() {
    return personId;
}

public void setPersonId(int personId) {
    this.personId = personId;
}

public boolean isIn() {
    return in;
}

public void setIn(boolean in) {
    this.in = in;
}
}
