package uta.macross.entry;

public class attribute {
    private int Attr_ID;
    private String Attr_Name;
    private String Attr_IMG;

    public attribute() {
    }

    public attribute(int attr_ID, String attr_Name, String attr_IMG) {
        Attr_ID = attr_ID;
        Attr_Name = attr_Name;
        Attr_IMG = attr_IMG;
    }

    public int getAttr_ID() {
        return Attr_ID;
    }

    public void setAttr_ID(int attr_ID) {
        Attr_ID = attr_ID;
    }

    public String getAttr_Name() {
        return Attr_Name;
    }

    public void setAttr_Name(String attr_Name) {
        Attr_Name = attr_Name;
    }

    public String getAttr_IMG() {
        return Attr_IMG;
    }

    public void setAttr_IMG(String attr_IMG) {
        Attr_IMG = attr_IMG;
    }
}
