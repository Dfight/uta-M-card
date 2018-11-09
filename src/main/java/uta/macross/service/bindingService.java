package uta.macross.service;

import uta.macross.entry.opus_card;
import uta.macross.entry.opus_fighter;

import java.util.HashMap;

public interface bindingService {
    public HashMap<String,String> getNoOpusCard();
    public int bindCardOpus(opus_card opusCard);
    public HashMap<String,String> getFighter();
    public int bindFighterOpus(opus_fighter opus_fighter);
}
