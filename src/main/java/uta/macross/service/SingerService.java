package uta.macross.service;

import uta.macross.entry.opus_singer;
import uta.macross.entry.singer;
import java.util.List;
public interface SingerService {
    //添加歌姬
    public int addSinger(singer s);
    //修改歌姬
    public int updateSinger(singer s);
    //搜索所有歌姬
    public List<singer> queryAllSinger();
    //添加歌姬作品
    public int addSingerOpus(opus_singer os);
    //通过歌姬获取作品
    public int getOpusBySingerID(int O_Singer_SID);
}
