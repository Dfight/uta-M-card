package uta.macross.entry;

public class attrCard {
    private int ac_id;
    private int ac_aid;
    private int ac_cid;

    public attrCard(int ac_id, int ac_aid, int ac_cid) {
        this.ac_id = ac_id;
        this.ac_aid = ac_aid;
        this.ac_cid = ac_cid;
    }

    public attrCard() {
    }

    public int getAc_id() {
        return ac_id;
    }

    public void setAc_id(int ac_id) {
        this.ac_id = ac_id;
    }

    public int getAc_aid() {
        return ac_aid;
    }

    public void setAc_aid(int ac_aid) {
        this.ac_aid = ac_aid;
    }

    public int getAc_cid() {
        return ac_cid;
    }

    public void setAc_cid(int ac_cid) {
        this.ac_cid = ac_cid;
    }

}
