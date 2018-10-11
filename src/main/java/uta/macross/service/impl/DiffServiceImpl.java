package uta.macross.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uta.macross.dao.DiffDao;
import uta.macross.entry.difficulty;
import uta.macross.service.DiffService;

import java.util.List;

@Service("diffService")
public class DiffServiceImpl implements DiffService {
    @Autowired
    public DiffDao diffDao;

    public int addDiff(difficulty diff) {
        return diffDao.addDiff(diff);
    }

    public List<difficulty> queryAllDiff() {
        return diffDao.queryAllDiff();
    }
}
