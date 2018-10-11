package uta.macross.dao;

import org.springframework.stereotype.Repository;
import uta.macross.entry.*;

@Repository
public interface SongDao {
    //添加歌曲
    public int addSong(song s);

    //作品是否已添加
    public int isOpus(opus_song os);
    //添加作品
    public int addOpus(opus_song s);
    //修改作品
    public int editOpus(opus_song s);

    //属性是否已添加
    public int isAttr(attrSong as);
    //添加属性
    public int addAttr(attrSong as);
    //修改属性
    public int editAttr(attrSong as);

    //难度是否已添加
    public int isDiff(song_detailed sd);
    //添加难度
    public int addDiff(song_detailed sd);
    //修改难度
    public int editDiff(song_detailed sd);

    //熟练度是否已添加
    public int isProf(singer_proficiency sp);
    //添加熟练度
    public int addProf(singer_proficiency sp);
    //修改熟练度
    public int editProf(singer_proficiency sp);

}
