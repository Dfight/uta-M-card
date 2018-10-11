package uta.macross.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uta.macross.entry.fighter;
import uta.macross.entry.opus_fighter;
import uta.macross.service.FighterService;

import java.util.List;

@Controller
@RequestMapping("/fighter")
public class FighterController {
    @Autowired
    public FighterService fighterService;
    @RequestMapping(value = "/addFighter",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addFighter(String fighterName,String fighterDriver,int fighterAttack,int fighterHit,String fighterIMG,int fighterOpus){
        fighter f = new fighter();
        f.setFighter_Name(fighterName);
        f.setFighter_Driver(fighterDriver);
        f.setFighter_Attack(fighterAttack);
        f.setFighter_Hit(fighterHit);
        f.setFighter_IMG(fighterIMG);
        fighterService.addFighter(f);
        opus_fighter of = new opus_fighter();
        of.setO_Fighter_FID(f.getFighter_ID());
        of.setO_Fighter_OID(fighterOpus);
        fighterService.addFighterOpus(of);
        JSONObject jsonObject = new JSONObject();
        return jsonObject.toJSONString();
    }
    @RequestMapping(value = "/queryAllFighter",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String queryAllFighter(){
        List<fighter> list = fighterService.queryAllFighter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res",list);
        return jsonObject.toJSONString();
    }
    @RequestMapping(value = "/queryFighterOpus",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String queryFighterOpus(int fighter){
        int opus = fighterService.queryFighterOpus(fighter);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res",opus);
        return jsonObject.toJSONString();
    }
}
