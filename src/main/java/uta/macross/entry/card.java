package uta.macross.entry;

public class card {
    private int Card_ID;
    private String Card_Name;

    public card() {
    }

    public card(int card_ID, String card_Name) {
        Card_ID = card_ID;
        Card_Name = card_Name;
    }

    public int getCard_ID() {
        return Card_ID;
    }

    public void setCard_ID(int card_ID) {
        Card_ID = card_ID;
    }

    public String getCard_Name() {
        return Card_Name;
    }

    public void setCard_Name(String card_Name) {
        Card_Name = card_Name;
    }
}
