package exams.oo_practice.elections;

import common.PersonName;

public class VoteData {
    private PersonName personName;
    private int region;
    private int vote;
    private PartiesType partiesType;

    public VoteData(PersonName personName, int region, int vote,PartiesType partiesType) {
        this.personName = personName;
        this.region = region;
        this.vote = vote;
        this.partiesType = partiesType;
    }

    public PersonName getPersonName() {
        return personName;
    }

    public void setPersonName(PersonName personName) {
        this.personName = personName;
    }

    public int getSerialNumber() {
        return region;
    }

    public void setSerialNumber(int serialNumber) {
        this.region = serialNumber;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public PartiesType getPartiesType() {
        return partiesType;
    }

    public void setPartiesType(PartiesType partiesType) {
        this.partiesType = partiesType;
    }
}
