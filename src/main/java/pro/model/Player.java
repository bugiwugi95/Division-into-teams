package pro.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Player {
    private int id;
    private String name;
    public Player() {}

    public Player(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return  name;
    }


}
