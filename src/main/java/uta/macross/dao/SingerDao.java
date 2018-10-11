package uta.macross.dao;


import org.springframework.stereotype.Repository;
import uta.macross.entry.opus_singer;
import uta.macross.entry.singer;

import java.util.List;
@Repository
public interface SingerDao {
    //获取所有歌姬信息
    public List<singer> queryAllSinger();
    //添加歌姬
    public int addSinger(singer s);
    //修改歌姬
    public int updataSinger(singer s);
    //添加歌姬作品
    public int addSingerOpus(opus_singer os);
    //通过歌姬获取作品
    public int getOpusBySingerID(int O_Singer_SID);
}
