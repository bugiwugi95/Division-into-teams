package pro.repository;

import pro.db.DatabaseHelper;
import pro.model.Teams;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamMemberRepository {

    private final DatabaseHelper databaseHelper;

    public TeamMemberRepository(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void saveTeam(int teamId, int playersId) {
        String sql = "INSERT INTO team_members (team_id,player_id) VALUES (?,?)";
        try (PreparedStatement pstmt = this.databaseHelper.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, teamId);
            pstmt.setInt(2, playersId);
            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении команды: " + e.getMessage());
        }

    }

    public List<Teams> getAllPlayers() {
// Логика для извлечения всех игроков из базы данных
        List<Teams> players = new ArrayList<>();
        String getPlayers = "SELECT * FROM teams";
        try {
            PreparedStatement pstmt = this.databaseHelper.getConnection().prepareStatement(getPlayers);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Teams teams = new Teams(name);
                players.add(teams);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при извлечении игроков: " + e.getMessage());
        }

        return players;

    }
}


