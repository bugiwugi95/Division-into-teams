package pro.model;

public class TeamMember {
    private int teamId;
    private int playerId;

    public TeamMember(int teamId, int playerId) {
        this.teamId = teamId;
        this.playerId = playerId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
