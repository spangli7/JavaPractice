package football;

public class Match {
    private int round;
    private int homeTeamGoalsEndOfTheMatch;
    private int guestTeamGoalsEndOfTheMatch;
    private int homeTeamGoalsHalfTime;
    private int guestTeamGoalsHalfTime;
    private String homeTeamName;
    private String guestTeamName;

    public Match(int turn, int homeTeamGoalsEndOfTheMatch, int guestTeamGoalsEndOfTheMatch, int homeTeamGoalsHalfTime,
                   int guestTeamGoalsHalfTime, String homeTeamName, String guestTeamName) {
        this.round = turn;
        this.homeTeamGoalsEndOfTheMatch = homeTeamGoalsEndOfTheMatch;
        this.guestTeamGoalsEndOfTheMatch = guestTeamGoalsEndOfTheMatch;
        this.homeTeamGoalsHalfTime = homeTeamGoalsHalfTime;
        this.guestTeamGoalsHalfTime = guestTeamGoalsHalfTime;
        this.homeTeamName = homeTeamName;
        this.guestTeamName = guestTeamName;
    }

    public int getTurn() {
        return round;
    }

    public void setTurn(int turn) {
        this.round = turn;
    }

    public int getHomeTeamGoalsEndOfTheMatch() {
        return homeTeamGoalsEndOfTheMatch;
    }

    public void setHomeTeamGoalsEndOfTheMatch(int homeTeamGoalsEndOfTheMatch) {
        this.homeTeamGoalsEndOfTheMatch = homeTeamGoalsEndOfTheMatch;
    }

    public int getGuestTeamGoalsEndOfTheMatch() {
        return guestTeamGoalsEndOfTheMatch;
    }

    public void setGuestTeamGoalsEndOfTheMatch(int guestTeamGoalsEndOfTheMatch) {
        this.guestTeamGoalsEndOfTheMatch = guestTeamGoalsEndOfTheMatch;
    }

    public int getHomeTeamGoalsHalfTime() {
        return homeTeamGoalsHalfTime;
    }

    public void setHomeTeamGoalsHalfTime(int homeTeamGoalsHalfTime) {
        this.homeTeamGoalsHalfTime = homeTeamGoalsHalfTime;
    }

    public int getGuestTeamGoalsHalfTime() {
        return guestTeamGoalsHalfTime;
    }

    public void setGuestTeamGoalsHalfTime(int guestTeamGoalsHalfTime) {
        this.guestTeamGoalsHalfTime = guestTeamGoalsHalfTime;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getGuestTeamName() {
        return guestTeamName;
    }

    public void setGuestTeamName(String guestTeamName) {
        this.guestTeamName = guestTeamName;
    }
}
