package uta.macross.entry;

public class card_unlock {
    private int ID;
    private int U_ID;
    private int C_ID;

    @Override
    public String toString() {
        return "card_unlock{" +
                "ID=" + ID +
                ", U_ID=" + U_ID +
                ", C_ID=" + C_ID +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getU_ID() {
        return U_ID;
    }

    public void setU_ID(int u_ID) {
        U_ID = u_ID;
    }

    public int getC_ID() {
        return C_ID;
    }

    public void setC_ID(int c_ID) {
        C_ID = c_ID;
    }

    public card_unlock(int ID, int u_ID, int c_ID) {
        this.ID = ID;
        U_ID = u_ID;
        C_ID = c_ID;
    }

    public card_unlock() {
    }
}
