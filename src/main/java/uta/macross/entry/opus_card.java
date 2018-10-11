package uta.macross.entry;

public class opus_card {
    private int O_Card_ID;
    private int O_Card_CID;
    private int O_Card_OID;

    public opus_card() {
    }

    public opus_card(int o_Card_ID, int o_Card_CID, int o_Card_OID) {
        O_Card_ID = o_Card_ID;
        O_Card_CID = o_Card_CID;
        O_Card_OID = o_Card_OID;
    }

    public int getO_Card_ID() {
        return O_Card_ID;
    }

    public void setO_Card_ID(int o_Card_ID) {
        O_Card_ID = o_Card_ID;
    }

    public int getO_Card_CID() {
        return O_Card_CID;
    }

    public void setO_Card_CID(int o_Card_CID) {
        O_Card_CID = o_Card_CID;
    }

    public int getO_Card_OID() {
        return O_Card_OID;
    }

    public void setO_Card_OID(int o_Card_OID) {
        O_Card_OID = o_Card_OID;
    }
}
