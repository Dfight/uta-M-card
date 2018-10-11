package uta.macross.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uta.macross.entry.opus;
import uta.macross.service.OpusService;

import java.util.List;

@Controller
@RequestMapping("/opus")
public class OpusController {
    @Autowired
    public OpusService opusService;

    @RequestMapping(value = "/addOpus",produces = "text/html;charset=utf-8")
    public String addOpus(String opusName,String opusIMG){
        opus o = new opus();
        o.setOpus_Name(opusName);
        o.setOpus_IMG(opusIMG);
        int i = opusService.addOpus(o);
        JSONObject jsonObject = new JSONObject();
        if (i == 1) {
            jsonObject.put("code", 1);
        } else {
            jsonObject.put("msg", "添加作品失败");
        }
        return jsonObject.toJSONString();
        }
    @RequestMapping(value = "/queryAllOpus",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String queryAllOpus(){
        List<opus> list= opusService.queryAllOpus();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res",list);
        String jsString = jsonObject.toJSONString();
        return jsString;
    }
}
