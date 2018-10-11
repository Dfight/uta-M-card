package uta.macross.service;

import uta.macross.entry.clothing;
import uta.macross.entry.singer_clothing;

import java.util.List;

public interface ClothingService {
    public int addClothing(clothing c);
    public int addClothingSinger(singer_clothing sc);
    public List<clothing> queryAllClothing();
    public int queryClothingSinger(int clothing);
}
