package uta.macross.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uta.macross.dao.ClothingDao;
import uta.macross.entry.clothing;
import uta.macross.entry.singer_clothing;
import uta.macross.service.ClothingService;

import java.util.List;
@Service("clothingService")
public class ClothingServiceImpl implements ClothingService {
    @Autowired
    public ClothingDao clothingDao;
    public int addClothing(clothing c) {
        return clothingDao.addClothing(c);
    }

    public int addClothingSinger(singer_clothing sc) {
        return clothingDao.addClothingSinger(sc);
    }

    public List<clothing> queryAllClothing() {
        return clothingDao.queryAllClothing();
    }

    public int queryClothingSinger(int clothing) {
        return clothingDao.queryClothingSinger(clothing);
    }
}
