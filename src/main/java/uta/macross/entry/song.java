package uta.macross.entry;

public class song {
    private int Song_ID;
    private String Song_Name;
    private String Song_IMG;
    private String Song_Singer;

    public song() {
    }

    public song(int song_ID, String song_Name, String song_IMG, String song_Singer) {
        Song_ID = song_ID;
        Song_Name = song_Name;
        Song_IMG = song_IMG;
        Song_Singer = song_Singer;
    }

    public int getSong_ID() {
        return Song_ID;
    }

    public void setSong_ID(int song_ID) {
        Song_ID = song_ID;
    }

    public String getSong_Name() {
        return Song_Name;
    }

    public void setSong_Name(String song_Name) {
        Song_Name = song_Name;
    }

    public String getSong_IMG() {
        return Song_IMG;
    }

    public void setSong_IMG(String song_IMG) {
        Song_IMG = song_IMG;
    }

    public String getSong_Singer() {
        return Song_Singer;
    }

    public void setSong_Singer(String song_Singer) {
        Song_Singer = song_Singer;
    }
}
