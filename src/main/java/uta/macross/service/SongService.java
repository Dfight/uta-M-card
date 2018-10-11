package uta.macross.service;

import uta.macross.entry.*;

public interface SongService {
    public int addSong(song s);
    public int isOpus(opus_song os);
    public int addOpus(opus_song os);
    public int editOpus(opus_song os);
    public int isAttr(attrSong as);
    public int addAttr(attrSong as);
    public int editAttr(attrSong as);
    public int isDiff(song_detailed sd);
    public int addDiff(song_detailed sd);
    public int editDiff(song_detailed sd);
    public int isProf(singer_proficiency sp);
    public int addProf(singer_proficiency sp);
    public int editProf(singer_proficiency sp);
}
