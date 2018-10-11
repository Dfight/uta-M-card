package uta.macross.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uta.macross.dao.FighterDao;
import uta.macross.entry.fighter;
import uta.macross.entry.opus_fighter;
import uta.macross.service.FighterService;

import java.util.List;

@Service("fighterService")
public class FighterServiceImpl implements FighterService {
    @Autowired
    public FighterDao fighterDao;
    public int addFighter(fighter f) {
        return fighterDao.addFighter(f);
    }

    public int addFighterOpus(opus_fighter of) {
        return fighterDao.addFighterOpus(of);
    }

    public List<fighter> queryAllFighter() {
        return fighterDao.queryAllFighter();
    }

    public int queryFighterOpus(int fighter) {
        return fighterDao.queryFighterOpus(fighter);
    }
}
