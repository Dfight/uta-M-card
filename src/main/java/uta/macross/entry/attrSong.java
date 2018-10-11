package uta.macross.entry;

public class attrSong {
    private int AS_ID;
    private int AS_AID;
    private int AS_SID;

    public int getAS_ID() {
        return AS_ID;
    }

    public void setAS_ID(int AS_ID) {
        this.AS_ID = AS_ID;
    }

    public int getAS_AID() {
        return AS_AID;
    }

    public void setAS_AID(int AS_AID) {
        this.AS_AID = AS_AID;
    }

    public int getAS_SID() {
        return AS_SID;
    }

    public void setAS_SID(int AS_SID) {
        this.AS_SID = AS_SID;
    }

    public attrSong() {
    }

    public attrSong(int AS_ID, int AS_AID, int AS_SID) {
        this.AS_ID = AS_ID;
        this.AS_AID = AS_AID;
        this.AS_SID = AS_SID;
    }
}
