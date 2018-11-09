package uta.macross.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uta.macross.entry.opus_card;
import uta.macross.entry.opus_fighter;
import uta.macross.service.bindingService;

import java.util.HashMap;

@Controller
@RequestMapping("/bind")
public class bindingController {
    @Autowired
    public bindingService bindingService;
    //获取一张没有绑定作品的卡
    @RequestMapping(value = "/getNoOpusCard",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getNoOpusCard(){
        JSONObject jsonObject = new JSONObject();
        HashMap<String, String> card = bindingService.getNoOpusCard();
        jsonObject.put("card",card);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/cardOpus",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String cardOpus(int card,int opus){
        JSONObject jsonObject = new JSONObject();
        opus_card opusCard = new opus_card();
        opusCard.setO_Card_OID(opus);
        opusCard.setO_Card_CID(card);
        bindingService.bindCardOpus(opusCard);
        return jsonObject.toJSONString();
    }

    //获取一张没有绑定作品的飞机
    @RequestMapping(value = "/getFighter",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getFighter(){
        JSONObject jsonObject = new JSONObject();
        HashMap<String, String> fighter = bindingService.getFighter();
        jsonObject.put("fighter",fighter);
        return jsonObject.toJSONString();
    }
    @RequestMapping(value = "/fighterOpus",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String fighterOpus(int fighter,int opus){
        JSONObject jsonObject = new JSONObject();
        opus_fighter opus_fighter = new opus_fighter();
        opus_fighter.setO_Fighter_OID(opus);
        opus_fighter.setO_Fighter_FID(fighter);
        bindingService.bindFighterOpus(opus_fighter);
        return jsonObject.toJSONString();
    }
}
