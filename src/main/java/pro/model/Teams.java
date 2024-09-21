package pro.model;

public class Teams {
    private int id;

    private String name;

    public Teams(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Teams(String name) {
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
}
