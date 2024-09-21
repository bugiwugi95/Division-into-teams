package pro.repository;

import pro.db.DatabaseHelper;
import pro.model.Teams;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamsRepository {

    private final DatabaseHelper databaseHelper;

    public TeamsRepository(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public int saveTeam(String teamName) {
        String sql = "INSERT INTO teams (team_name) VALUES (?) RETURNING id";
        try (PreparedStatement pstmt = this.databaseHelper.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, teamName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                return rs.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении команды: " + e.getMessage());
        }
        return -1;
    }

    public List<Teams> getAllPlayers() {
// Логика для извлечения всех игроков из базы данных
        List<Teams> players = new ArrayList<>();
        String getPlayers = "SELECT * FROM teams";
        try {
            PreparedStatement pstmt = this.databaseHelper.getConnection().prepareStatement(getPlayers);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("team_name");
                Teams teams = new Teams(name);
                players.add(teams);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при извлечении игроков: " + e.getMessage());
        }

        return players;

    }
}


