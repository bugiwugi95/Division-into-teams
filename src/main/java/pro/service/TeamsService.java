package pro.service;

import pro.db.DatabaseHelper;
import pro.model.Player;
import pro.repository.PlayerRepository;
import pro.repository.TeamMemberRepository;
import pro.repository.TeamsRepository;

import java.util.List;

public class TeamsService {

    private final TeamsRepository teamsRepository;
    private final TeamMemberRepository teamMemberRepository;
    private final PlayerRepository playerRepository;

    public TeamsService(DatabaseHelper databaseHelper) {
        this.teamsRepository = new TeamsRepository(databaseHelper);
        this.teamMemberRepository = new TeamMemberRepository(databaseHelper);
        this.playerRepository = new PlayerRepository(databaseHelper);
    }

    public void createTeam(String teamName, List<Player> players) {
        int teamId = teamsRepository.saveTeam(teamName);
        System.out.println("Team " + teamName + ":");
        for (Player player : players) {
            int playerId = playerRepository.getPlayer(player.getName());
            teamMemberRepository.saveTeam(teamId, playerId);
            System.out.println(player);
        }
    }


}
