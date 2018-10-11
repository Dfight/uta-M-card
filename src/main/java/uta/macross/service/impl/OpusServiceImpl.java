package uta.macross.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uta.macross.dao.OpusDao;
import uta.macross.entry.opus;
import uta.macross.service.OpusService;

import java.util.List;

@Service("opusService")
public class OpusServiceImpl implements OpusService {
    @Autowired
    public OpusDao opusDao;
    public int addOpus(opus o) {
        return opusDao.addOpus(o);
    }

    public List<opus> queryAllOpus() {
        return opusDao.queryAllOpus();
    }
}
