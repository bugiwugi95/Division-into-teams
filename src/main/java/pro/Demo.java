package pro;


import pro.db.DatabaseHelper;
import pro.model.Player;
import pro.service.PlayerService;
import pro.service.TeamsService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        DatabaseHelper databaseHelper = new DatabaseHelper("jdbc:postgresql://localhost:5432/Soccer3");
        PlayerService playerService = new PlayerService(databaseHelper);
        TeamsService teamsService = new TeamsService(databaseHelper);

        Scanner in = new Scanner(System.in);
        String namePlayers;
        List<Player> players = new ArrayList<>();
        // Заполнение списка игроков
        System.out.println("Введите количество игроков:");
        int numberOfPlayers = in.nextInt();
        in.nextLine();

        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player();
            System.out.println("Input players - " + (i + 1) + "#");
            namePlayers = in.nextLine();
            player.setName(namePlayers);
            players.add(player);
        }

        playerService.savePlayers(players);


        Collections.shuffle(players);
        int mid = players.size() / 2;
        List<Player> teamA = players.subList(0, mid);
        List<Player> teamB = players.subList(mid, players.size());

        teamsService.createTeam("5t", teamA);
        teamsService.createTeam("6y", teamB);

        System.out.println("5t" + "->" + teamA);
        System.out.println("6y" + "->" + teamB);


    }

    /*
    Teесты,гит,вывод в консоль команд двух.
     */

}
