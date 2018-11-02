package uta.macross.entry;

public class skill {
    private int Skill_ID;
    private int Skill_Type;
    private String Skill_LV;
    private String Skill_J;
    private String Skill_J_max;
    private String Skill_C;
    private String Skill_C_max;

    public skill() {
    }

    @Override
    public String toString() {
        return "skill{" +
                "Skill_ID=" + Skill_ID +
                ", Skill_Type=" + Skill_Type +
                ", Skill_LV='" + Skill_LV + '\'' +
                ", Skill_J='" + Skill_J + '\'' +
                ", Skill_J_max='" + Skill_J_max + '\'' +
                ", Skill_C='" + Skill_C + '\'' +
                ", Skill_C_max='" + Skill_C_max + '\'' +
                '}';
    }

    public skill(int skill_ID, int skill_Type, String skill_LV, String skill_J, String skill_J_max, String skill_C, String skill_C_max) {
        Skill_ID = skill_ID;
        Skill_Type = skill_Type;
        Skill_LV = skill_LV;
        Skill_J = skill_J;
        Skill_J_max = skill_J_max;
        Skill_C = skill_C;
        Skill_C_max = skill_C_max;
    }

    public String getSkill_J_max() {
        return Skill_J_max;
    }

    public void setSkill_J_max(String skill_J_max) {
        Skill_J_max = skill_J_max;
    }

    public String getSkill_C_max() {
        return Skill_C_max;
    }

    public void setSkill_C_max(String skill_C_max) {
        Skill_C_max = skill_C_max;
    }

    public int getSkill_ID() {
        return Skill_ID;
    }

    public void setSkill_ID(int skill_ID) {
        Skill_ID = skill_ID;
    }

    public int getSkill_Type() {
        return Skill_Type;
    }

    public void setSkill_Type(int skill_Type) {
        Skill_Type = skill_Type;
    }

    public String getSkill_LV() {
        return Skill_LV;
    }

    public void setSkill_LV(String skill_LV) {
        Skill_LV = skill_LV;
    }

    public String getSkill_J() {
        return Skill_J;
    }

    public void setSkill_J(String skill_J) {
        Skill_J = skill_J;
    }

    public String getSkill_C() {
        return Skill_C;
    }

    public void setSkill_C(String skill_C) {
        Skill_C = skill_C;
    }
}
