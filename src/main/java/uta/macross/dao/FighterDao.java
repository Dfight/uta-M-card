package uta.macross.dao;

import org.springframework.stereotype.Repository;
import uta.macross.entry.fighter;
import uta.macross.entry.opus_fighter;

import java.util.List;

@Repository
public interface FighterDao {
    public int addFighter(fighter f);
    public int addFighterOpus(opus_fighter of);
    public List<fighter> queryAllFighter();
    public int queryFighterOpus(int fighter);
}
