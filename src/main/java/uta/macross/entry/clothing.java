package uta.macross.entry;

public class clothing {
    private int Clothing_ID;
    private String Clothing_Name;
    private String Clothing_Features;
    private String Clothing_IMG;

    public clothing() {
    }

    public clothing(int clothing_ID, String clothing_Name, String clothing_Features, String clothing_IMG) {
        Clothing_ID = clothing_ID;
        Clothing_Name = clothing_Name;
        Clothing_Features = clothing_Features;
        Clothing_IMG = clothing_IMG;
    }

    public int getClothing_ID() {
        return Clothing_ID;
    }

    public void setClothing_ID(int clothing_ID) {
        Clothing_ID = clothing_ID;
    }

    public String getClothing_Name() {
        return Clothing_Name;
    }

    public void setClothing_Name(String clothing_Name) {
        Clothing_Name = clothing_Name;
    }

    public String getClothing_Features() {
        return Clothing_Features;
    }

    public void setClothing_Features(String clothing_Features) {
        Clothing_Features = clothing_Features;
    }

    public String getClothing_IMG() {
        return Clothing_IMG;
    }

    public void setClothing_IMG(String clothing_IMG) {
        Clothing_IMG = clothing_IMG;
    }
}
