package uta.macross.entry;

public class opus {
    private int Opus_ID;
    private String Opus_Name;
    private String Opus_IMG;

    public opus(int opus_ID, String opus_Name, String opus_IMG) {
        Opus_ID = opus_ID;
        Opus_Name = opus_Name;
        Opus_IMG = opus_IMG;
    }

    public opus() {
    }

    public String getOpus_IMG() {
        return Opus_IMG;
    }

    public void setOpus_IMG(String opus_IMG) {
        Opus_IMG = opus_IMG;
    }

    public int getOpus_ID() {
        return Opus_ID;
    }

    public void setOpus_ID(int opus_ID) {
        Opus_ID = opus_ID;
    }

    public String getOpus_Name() {
        return Opus_Name;
    }

    public void setOpus_Name(String opus_Name) {
        Opus_Name = opus_Name;
    }
}
