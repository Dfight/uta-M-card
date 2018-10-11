package uta.macross.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uta.macross.dao.SongDao;
import uta.macross.entry.*;
import uta.macross.service.SongService;
@Service("songService")
public class SongServiceImol implements SongService {
    @Autowired
    public SongDao songDao;
    public int addSong(song s) {
        return songDao.addSong(s);
    }

    public int isOpus(opus_song os) {
        return songDao.isOpus(os);
    }

    public int addOpus(opus_song os) {
        return songDao.addOpus(os);
    }

    public int editOpus(opus_song os) {
        return songDao.editOpus(os);
    }

    public int isAttr(attrSong as) {
        return songDao.isAttr(as);
    }

    public int addAttr(attrSong as) {
        return songDao.addAttr(as);
    }

    public int editAttr(attrSong as) {
        return songDao.editAttr(as);
    }

    public int isDiff(song_detailed sd) {
        return songDao.isDiff(sd);
    }

    public int addDiff(song_detailed sd) {
        return songDao.addDiff(sd);
    }

    public int editDiff(song_detailed sd) {
        return songDao.editDiff(sd);
    }

    public int isProf(singer_proficiency sp) {
        return songDao.isProf(sp);
    }

    public int addProf(singer_proficiency sp) {
        return songDao.addProf(sp);
    }

    public int editProf(singer_proficiency sp) {
        return songDao.editProf(sp);
    }
}
