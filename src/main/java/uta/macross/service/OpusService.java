package uta.macross.service;

import uta.macross.entry.opus;

import java.util.List;

public interface OpusService {
    //添加作品
    public int addOpus(opus o);
    //搜索所有作品
    public List<opus> queryAllOpus();
}
