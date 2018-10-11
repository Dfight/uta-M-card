package uta.macross.service;

import uta.macross.entry.fighter;
import uta.macross.entry.opus_fighter;

import java.util.List;

public interface FighterService {
    public int addFighter(fighter f);
    public int addFighterOpus(opus_fighter of);
    public List<fighter> queryAllFighter();
    public int queryFighterOpus(int fighter);
}
