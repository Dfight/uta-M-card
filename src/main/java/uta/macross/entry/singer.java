package uta.macross.entry;

public class singer {
    private int Singer_ID;
    private String Singer_Name;
    private String Singer_IMG;
    private String Singer_IMG1;
    public singer() {
    }

    public singer(int singer_ID, String singer_Name, String singer_IMG, String singer_IMG1) {
        Singer_ID = singer_ID;
        Singer_Name = singer_Name;
        Singer_IMG = singer_IMG;
        Singer_IMG1 = singer_IMG1;
    }

    public String getSinger_IMG1() {
        return Singer_IMG1;
    }

    public void setSinger_IMG1(String singer_IMG1) {
        Singer_IMG1 = singer_IMG1;
    }

    public int getSinger_ID() {
        return Singer_ID;
    }

    public void setSinger_ID(int singer_ID) {
        Singer_ID = singer_ID;
    }

    public String getSinger_Name() {
        return Singer_Name;
    }

    public void setSinger_Name(String singer_Name) {
        Singer_Name = singer_Name;
    }

    public String getSinger_IMG() {
        return Singer_IMG;
    }

    public void setSinger_IMG(String singer_IMG) {
        Singer_IMG = singer_IMG;
    }
}
