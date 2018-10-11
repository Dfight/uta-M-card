package uta.macross.entry;

public class fighter {
    private int Fighter_ID;
    private String Fighter_Name;
    private String Fighter_Driver;
    private int Fighter_Attack;
    private int Fighter_Hit;
    private String Fighter_IMG;

    public fighter() {
    }

    public fighter(int fighter_ID, String fighter_Name, String fighter_Driver, int fighter_Attack, int fighter_Hit, String fighter_IMG) {
        Fighter_ID = fighter_ID;
        Fighter_Name = fighter_Name;
        Fighter_Driver = fighter_Driver;
        Fighter_Attack = fighter_Attack;
        Fighter_Hit = fighter_Hit;
        Fighter_IMG = fighter_IMG;
    }

    public int getFighter_ID() {
        return Fighter_ID;
    }

    public void setFighter_ID(int fighter_ID) {
        Fighter_ID = fighter_ID;
    }

    public String getFighter_Name() {
        return Fighter_Name;
    }

    public void setFighter_Name(String fighter_Name) {
        Fighter_Name = fighter_Name;
    }

    public String getFighter_Driver() {
        return Fighter_Driver;
    }

    public void setFighter_Driver(String fighter_Driver) {
        Fighter_Driver = fighter_Driver;
    }

    public int getFighter_Attack() {
        return Fighter_Attack;
    }

    public void setFighter_Attack(int fighter_Attack) {
        Fighter_Attack = fighter_Attack;
    }

    public int getFighter_Hit() {
        return Fighter_Hit;
    }

    public void setFighter_Hit(int fighter_Hit) {
        Fighter_Hit = fighter_Hit;
    }

    public String getFighter_IMG() {
        return Fighter_IMG;
    }

    public void setFighter_IMG(String fighter_IMG) {
        Fighter_IMG = fighter_IMG;
    }
}
