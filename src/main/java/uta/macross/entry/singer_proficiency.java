package uta.macross.entry;

public class singer_proficiency {
    private int S_P_ID;
    private int S_P_SongID;
    private int S_P_SingerID;
    private String S_P_Unlock;

    public singer_proficiency() {
    }

    public singer_proficiency(int s_P_ID, int s_P_SongID, int s_P_SingerID, String s_P_Unlock) {
        S_P_ID = s_P_ID;
        S_P_SongID = s_P_SongID;
        S_P_SingerID = s_P_SingerID;
        S_P_Unlock = s_P_Unlock;
    }

    public int getS_P_ID() {
        return S_P_ID;
    }

    public void setS_P_ID(int s_P_ID) {
        S_P_ID = s_P_ID;
    }

    public int getS_P_SongID() {
        return S_P_SongID;
    }

    public void setS_P_SongID(int s_P_SongID) {
        S_P_SongID = s_P_SongID;
    }

    public int getS_P_SingerID() {
        return S_P_SingerID;
    }

    public void setS_P_SingerID(int s_P_SingerID) {
        S_P_SingerID = s_P_SingerID;
    }

    public String getS_P_Unlock() {
        return S_P_Unlock;
    }

    public void setS_P_Unlock(String s_P_Unlock) {
        S_P_Unlock = s_P_Unlock;
    }
}
