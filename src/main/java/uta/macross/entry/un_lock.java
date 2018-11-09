package uta.macross.entry;

public class un_lock {
    private int U_ID;
    private String U_Name;
    private int U_Fighter;
    private int U_Clothing;
    private String U_IMG;

    public String getU_IMG() {
        return U_IMG;
    }

    public void setU_IMG(String u_IMG) {
        U_IMG = u_IMG;
    }

    @Override
    public String toString() {
        return "un_lock{" +
                "U_ID=" + U_ID +
                ", U_Name='" + U_Name + '\'' +
                ", U_Fighter=" + U_Fighter +
                ", U_Clothing=" + U_Clothing +
                ", U_IMG='" + U_IMG + '\'' +
                '}';
    }

    public un_lock(int u_ID, String u_Name, int u_Fighter, int u_Clothing, String u_IMG) {
        U_ID = u_ID;
        U_Name = u_Name;
        U_Fighter = u_Fighter;
        U_Clothing = u_Clothing;
        U_IMG = u_IMG;
    }

    public un_lock() {
    }

    public int getU_ID() {
        return U_ID;
    }

    public void setU_ID(int u_Id) {
        U_ID = u_Id;
    }

    public String getU_Name() {
        return U_Name;
    }

    public void setU_Name(String u_Name) {
        U_Name = u_Name;
    }

    public int getU_Fighter() {
        return U_Fighter;
    }

    public void setU_Fighter(int u_Fighter) {
        U_Fighter = u_Fighter;
    }

    public int getU_Clothing() {
        return U_Clothing;
    }

    public void setU_Clothing(int u_Clothing) {
        U_Clothing = u_Clothing;
    }


}
