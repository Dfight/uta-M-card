package uta.macross.entry;

public class skill_type {
    private int id;
    private String pos;
    private String type;

    public skill_type() {
    }

    public skill_type(int id, String pos, String type) {
        this.id = id;
        this.pos = pos;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
