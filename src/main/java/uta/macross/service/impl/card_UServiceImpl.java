package uta.macross.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uta.macross.dao.Card_uDao;
import uta.macross.entry.cardClothingFighter;
import uta.macross.service.Card_uService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("card_uService")
public class card_UServiceImpl implements Card_uService {
    @Autowired
    public Card_uDao card_uDao;
    public List<HashMap<String, Object>> getAllCard(List<Integer> attr, List<Integer> opus, Integer fighter, Integer clothing, Integer star, Integer start, Integer end, List<Integer> singer) {
        return card_uDao.getAllCard(attr,opus,fighter,clothing,star,start,end,singer);
    }

    public cardClothingFighter getCardType(Integer id) {
        return card_uDao.getCardType(id);
    }

    public HashMap<String,Object> getCardF(Integer id) {
        return card_uDao.getCardF(id);
    }

    public HashMap<String,Object> getCardC(Integer id) {
        return card_uDao.getCardC(id);
    }

    public List<HashMap<String,Object>> getSingerByCard(Integer id) {
        return card_uDao.getSingerByCard(id);
    }

    public HashMap<String,Object> getSkillByType(String type) {
        return card_uDao.getSkillByType(type);
    }
}
