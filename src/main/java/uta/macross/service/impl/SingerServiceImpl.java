package uta.macross.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uta.macross.dao.SingerDao;
import uta.macross.entry.opus_singer;
import uta.macross.entry.singer;
import uta.macross.service.SingerService;

import java.util.List;
@Service("singerService")
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerDao singerDao;

    public int addSinger(singer s) {
        return singerDao.addSinger(s);
    }

    public int updateSinger(singer s) {
        return singerDao.updataSinger(s);
    }

    public List<singer> queryAllSinger() {
        return singerDao.queryAllSinger();
    }

    public int addSingerOpus(opus_singer os) {
        return singerDao.addSingerOpus(os);
    }

    public int getOpusBySingerID(int O_Singer_SID) {
        return singerDao.getOpusBySingerID(O_Singer_SID);
    }
}
