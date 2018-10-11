package uta.macross.entry;

public class opus_singer {
    private int O_Singer_ID;
    private int O_Singer_SID;
    private int O_Singer_OID;

    public opus_singer() {
    }

    public opus_singer(int o_Singer_ID, int o_Singer_SID, int o_Singer_OID) {
        O_Singer_ID = o_Singer_ID;
        O_Singer_SID = o_Singer_SID;
        O_Singer_OID = o_Singer_OID;
    }

    public int getO_Singer_ID() {
        return O_Singer_ID;
    }

    public void setO_Singer_ID(int o_Singer_ID) {
        O_Singer_ID = o_Singer_ID;
    }

    public int getO_Singer_SID() {
        return O_Singer_SID;
    }

    public void setO_Singer_SID(int o_Singer_SID) {
        O_Singer_SID = o_Singer_SID;
    }

    public int getO_Singer_OID() {
        return O_Singer_OID;
    }

    public void setO_Singer_OID(int o_Singer_OID) {
        O_Singer_OID = o_Singer_OID;
    }
}
