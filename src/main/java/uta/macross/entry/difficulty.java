package uta.macross.entry;

public class difficulty {
    private int Diff_ID;
    private String Diff_Diff;
    private int Diff_Consume;

    public difficulty() {
    }

    public difficulty(int diff_ID, String diff_Diff, int diff_Consume) {
        Diff_ID = diff_ID;
        Diff_Diff = diff_Diff;
        Diff_Consume = diff_Consume;
    }

    public int getDiff_ID() {
        return Diff_ID;
    }

    public void setDiff_ID(int diff_ID) {
        Diff_ID = diff_ID;
    }

    public String getDiff_Diff() {
        return Diff_Diff;
    }

    public void setDiff_Diff(String diff_Diff) {
        Diff_Diff = diff_Diff;
    }

    public int getDiff_Consume() {
        return Diff_Consume;
    }

    public void setDiff_Consume(int diff_Consume) {
        Diff_Consume = diff_Consume;
    }
}
