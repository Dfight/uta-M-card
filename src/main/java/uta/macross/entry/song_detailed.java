package uta.macross.entry;

public class song_detailed {
    private int S_D_ID;
    private int S_D_SID;
    private int S_D_DID;
    private int S_D_Rank;
    private int S_D_FC;
    private String S_D_Unlock;

    public song_detailed() {
    }

    public song_detailed(int s_D_ID, int s_D_SID, int s_D_DID, int s_D_Rank, int s_D_FC, String s_D_Unlock) {
        S_D_ID = s_D_ID;
        S_D_SID = s_D_SID;
        S_D_DID = s_D_DID;
        S_D_Rank = s_D_Rank;
        S_D_FC = s_D_FC;
        S_D_Unlock = s_D_Unlock;
    }

    public int getS_D_ID() {
        return S_D_ID;
    }

    public void setS_D_ID(int s_D_ID) {
        S_D_ID = s_D_ID;
    }

    public int getS_D_SID() {
        return S_D_SID;
    }

    public void setS_D_SID(int s_D_SID) {
        S_D_SID = s_D_SID;
    }

    public int getS_D_DID() {
        return S_D_DID;
    }

    public void setS_D_DID(int s_D_DID) {
        S_D_DID = s_D_DID;
    }

    public int getS_D_Rank() {
        return S_D_Rank;
    }

    public void setS_D_Rank(int s_D_Rank) {
        S_D_Rank = s_D_Rank;
    }

    public int getS_D_FC() {
        return S_D_FC;
    }

    public void setS_D_FC(int s_D_FC) {
        S_D_FC = s_D_FC;
    }

    public String getS_D_Unlock() {
        return S_D_Unlock;
    }

    public void setS_D_Unlock(String s_D_Unlock) {
        S_D_Unlock = s_D_Unlock;
    }
}
