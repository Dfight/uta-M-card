package uta.macross.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uta.macross.entry.opus_singer;
import uta.macross.entry.singer;
import uta.macross.service.SingerService;

import java.util.List;

@Controller
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private SingerService singerService;

    @RequestMapping(value = "/addSinger",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addSinger(String SingerName,String SingerIMG,String SingerIMG1,String SingerOpus) {
        singer s = new singer();
        s.setSinger_Name(SingerName);
        s.setSinger_IMG(SingerIMG);
        s.setSinger_IMG1(SingerIMG1);
        int i = singerService.addSinger(s);
        opus_singer opus_singer = new opus_singer();
        opus_singer.setO_Singer_SID(s.getSinger_ID());
        opus_singer.setO_Singer_OID(Integer.parseInt(SingerOpus));
        JSONObject jsonObject = new JSONObject();
        if (i == 1) {
            jsonObject.put("code", 1);
        } else {
            jsonObject.put("msg", "添加歌姬失败");
        }
        return jsonObject.toJSONString();
    }
    @RequestMapping(value = "/updataSinger",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String updataSinger(int Singer_ID,String Singer_Name,String Sing_IMG){
        singer s = new singer();
        s.setSinger_ID(Singer_ID);
        s.setSinger_Name(Singer_Name);
        s.setSinger_IMG(Sing_IMG);
        int i = singerService.updateSinger(s);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res",i);
        return jsonObject.toJSONString();
    }
    @RequestMapping(value = "/queryAllSinger",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String queryAllSinger(){
        List<singer> list= singerService.queryAllSinger();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res",list);
        String jsString = jsonObject.toJSONString();
        return jsString;
    }
    @RequestMapping(value = "/getOpusBySingerID",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getOpusBySingerID(String id) {
        int O_Singer_SID = Integer.parseInt(id);
        int Opus_ID = singerService.getOpusBySingerID(O_Singer_SID);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Opus_ID",Opus_ID);
        return jsonObject.toJSONString();
    }
}
