package uta.macross.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uta.macross.dao.bindingDao;
import uta.macross.entry.opus_card;
import uta.macross.entry.opus_fighter;
import uta.macross.service.bindingService;

import java.util.HashMap;

@Service("bindingService")
public class bindingServiceImpl implements bindingService {
    @Autowired
    public bindingDao bindingDao;

    public HashMap<String, String> getNoOpusCard() {
        return bindingDao.getNoOpusCard();
    }

    public int bindCardOpus(opus_card opusCard) {
        return bindingDao.bindCardOpus(opusCard);
    }

    public HashMap<String, String> getFighter() {
        return bindingDao.getFighter();
    }

    public int bindFighterOpus(opus_fighter opus_fighter) {
        return bindingDao.bindFighterOpus(opus_fighter);
    }
}
