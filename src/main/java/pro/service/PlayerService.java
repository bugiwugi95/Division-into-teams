package pro.service;

import pro.db.DatabaseHelper;
import pro.model.Player;
import pro.repository.PlayerRepository;

import java.util.List;

public class PlayerService {

    private final PlayerRepository repository;

    public PlayerService(DatabaseHelper databaseHelper) {
        this.repository = new PlayerRepository(databaseHelper);
    }


    public void savePlayers(List<Player> players) {
        for (Player player : players) {
            int playerId = repository.savePlayer(player);
            if (playerId != -1) {
                player.setId(playerId);
            }
        }
        System.out.println("Saved players: " + repository.getAllPlayers());
    }


}
