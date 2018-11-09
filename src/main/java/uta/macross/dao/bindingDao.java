package uta.macross.dao;

import org.springframework.stereotype.Repository;
import uta.macross.entry.opus_card;
import uta.macross.entry.opus_fighter;

import java.util.HashMap;

@Repository
public interface bindingDao {
    public HashMap<String,String> getNoOpusCard();
    public int bindCardOpus(opus_card opusCard);
    public HashMap<String,String> getFighter();
    public int bindFighterOpus(opus_fighter opus_fighter);
}
