package uta.macross.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uta.macross.entry.*;
import uta.macross.service.SongService;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    public SongService songService;
    @RequestMapping(value = "/addSong",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addSong(String songname,String songIMG,String songsinger){
        song s = new song();
        s.setSong_Name(songname);
        s.setSong_IMG(songIMG);
        s.setSong_Singer(songsinger);
        int i = songService.addSong(s);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("res",s.getSong_ID());
        return jsonObject.toJSONString();
    }
    @RequestMapping(value = "/addSongOpusAttr",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addSongOpusAttr(int songID,int opus,int attr){
        opus_song os = new opus_song();
        os.setO_Song_SID(songID);
        os.setO_Song_OID(opus);
        int i1 = songService.isOpus(os);
        if(i1==0){
            songService.addOpus(os);
        }else{
            songService.editOpus(os);
        }
        attrSong as = new attrSong();
        as.setAS_AID(attr);
        as.setAS_SID(songID);
        int i2 = songService.isAttr(as);
        if (i2==0){
            songService.addAttr(as);
        }else{
            songService.editAttr(as);
        }
        JSONObject jsonObject = new JSONObject();
        return jsonObject.toJSONString();
    }
    @RequestMapping(value = "/addSongDiff",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addSongDiff(int songID,int diff,int songRank,int songFCNum,String songUnlock){
        song_detailed sd = new song_detailed();
        sd.setS_D_DID(diff);
        sd.setS_D_SID(songID);
        sd.setS_D_FC(songFCNum);
        sd.setS_D_Rank(songRank);
        sd.setS_D_Unlock(songUnlock);
        int i = songService.isDiff(sd);
        if (i==0){
            songService.addDiff(sd);
        }else{
            songService.editDiff(sd);
        }
        JSONObject jsonObject = new JSONObject();
        return jsonObject.toJSONString();
    }
    @RequestMapping(value = "/addSongSinger",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addSongSinger(int songID,int singer,String singerUnlock){
        singer_proficiency sp = new singer_proficiency();
        sp.setS_P_SingerID(singer);
        sp.setS_P_SongID(songID);
        sp.setS_P_Unlock(singerUnlock);
        int i = songService.isProf(sp);
        if (i==0){
            songService.addProf(sp);
        }else{
            songService.editProf(sp);
        }
        JSONObject jsonObject = new JSONObject();
        return jsonObject.toJSONString();
    }
}
