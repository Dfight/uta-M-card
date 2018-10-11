package uta.macross.entry;

public class singer_card {
    private int Singer_Card_ID;
    private int Singer_Card_CID;
    private int Singer_Card_SID;

    public singer_card() {
    }

    public singer_card(int singer_Card_ID, int singer_Card_CID, int singer_Card_SID) {
        Singer_Card_ID = singer_Card_ID;
        Singer_Card_CID = singer_Card_CID;
        Singer_Card_SID = singer_Card_SID;
    }

    public int getSinger_Card_ID() {
        return Singer_Card_ID;
    }

    public void setSinger_Card_ID(int singer_Card_ID) {
        Singer_Card_ID = singer_Card_ID;
    }

    public int getSinger_Card_CID() {
        return Singer_Card_CID;
    }

    public void setSinger_Card_CID(int singer_Card_CID) {
        Singer_Card_CID = singer_Card_CID;
    }

    public int getSinger_Card_SID() {
        return Singer_Card_SID;
    }

    public void setSinger_Card_SID(int singer_Card_SID) {
        Singer_Card_SID = singer_Card_SID;
    }
}
