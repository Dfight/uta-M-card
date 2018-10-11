package uta.macross.entry;

public class opus_song {
    private int O_Song_ID;
    private int O_Song_SID;
    private int O_Song_OID;

    public opus_song() {
    }

    public opus_song(int o_Song_ID, int o_Song_SID, int o_Song_OID) {
        O_Song_ID = o_Song_ID;
        O_Song_SID = o_Song_SID;
        O_Song_OID = o_Song_OID;
    }

    public int getO_Song_ID() {
        return O_Song_ID;
    }

    public void setO_Song_ID(int o_Song_ID) {
        O_Song_ID = o_Song_ID;
    }

    public int getO_Song_SID() {
        return O_Song_SID;
    }

    public void setO_Song_SID(int o_Song_SID) {
        O_Song_SID = o_Song_SID;
    }

    public int getO_Song_OID() {
        return O_Song_OID;
    }

    public void setO_Song_OID(int o_Song_OID) {
        O_Song_OID = o_Song_OID;
    }
}
