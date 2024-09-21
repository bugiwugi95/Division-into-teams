package pro.repository;

import pro.model.Player;
import pro.db.DatabaseHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {

    private final DatabaseHelper databaseHelper;



    public PlayerRepository(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }



    public int savePlayer(Player player) {
        // Логика для добавления игрока в базу данных
        String sql = "INSERT INTO players (name) VALUES (?) RETURNING id";
        try (PreparedStatement pstmt = this.databaseHelper.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, player.getName());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    player.setId(rs.getInt("id"));
                    return player.getId();
                } else {
                    System.out.println("Не удалось получить сгенерированный идентификатор");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении игрока: " + e.getMessage());
        }
        return -1;
    }

    public List<Player> getAllPlayers() {
// Логика для извлечения всех игроков из базы данных
        List<Player> players = new ArrayList<>();
        String getPlayers = "SELECT * FROM players";
        try {
            PreparedStatement pstmt = this.databaseHelper.getConnection().prepareStatement(getPlayers);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Player player = new Player(name);
                players.add(player);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при извлечении игроков: " + e.getMessage());
        }

        return players;

    }


    public int getPlayer(String name){
        String getPlayers = "SELECT id FROM players WHERE name = ?";
        try {
            PreparedStatement pstmt = this.databaseHelper.getConnection().prepareStatement(getPlayers);
           pstmt.setString(1,name);
           ResultSet rs = pstmt.executeQuery();
           if (rs.next()){
               return rs.getInt("id");
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


}


