package uta.macross.entry;

public class opus_fighter {
    private int O_Fighter_ID;
    private int O_Fighter_FID;
    private int O_Fighter_OID;

    public opus_fighter() {
    }

    public opus_fighter(int o_Fighter_ID, int o_Fighter_FID, int o_Fighter_OID) {
        O_Fighter_ID = o_Fighter_ID;
        O_Fighter_FID = o_Fighter_FID;
        O_Fighter_OID = o_Fighter_OID;
    }

    public int getO_Fighter_ID() {
        return O_Fighter_ID;
    }

    public void setO_Fighter_ID(int o_Fighter_ID) {
        O_Fighter_ID = o_Fighter_ID;
    }

    public int getO_Fighter_FID() {
        return O_Fighter_FID;
    }

    public void setO_Fighter_FID(int o_Fighter_FID) {
        O_Fighter_FID = o_Fighter_FID;
    }

    public int getO_Fighter_OID() {
        return O_Fighter_OID;
    }

    public void setO_Fighter_OID(int o_Fighter_OID) {
        O_Fighter_OID = o_Fighter_OID;
    }
}
