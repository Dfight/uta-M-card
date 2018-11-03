package uta.macross.entry;

public class unlock {
    private int U_Id;
    private String U_Name;
    private String U_Fighter;
    private String U_Clothing;

    public unlock() {
    }

    public unlock(int u_Id, String u_Name, String u_Fighter, String u_Clothing) {
        U_Id = u_Id;
        U_Name = u_Name;
        U_Fighter = u_Fighter;
        U_Clothing = u_Clothing;
    }

    public int getU_Id() {
        return U_Id;
    }

    public void setU_Id(int u_Id) {
        U_Id = u_Id;
    }

    public String getU_Name() {
        return U_Name;
    }

    public void setU_Name(String u_Name) {
        U_Name = u_Name;
    }

    public String getU_Fighter() {
        return U_Fighter;
    }

    public void setU_Fighter(String u_Fighter) {
        U_Fighter = u_Fighter;
    }

    public String getU_Clothing() {
        return U_Clothing;
    }

    public void setU_Clothing(String u_Clothing) {
        U_Clothing = u_Clothing;
    }

    @Override
    public String toString() {
        return "unlock{" +
                "U_Id=" + U_Id +
                ", U_Name='" + U_Name + '\'' +
                ", U_Fighter='" + U_Fighter + '\'' +
                ", U_Clothing='" + U_Clothing + '\'' +
                '}';
    }
}
