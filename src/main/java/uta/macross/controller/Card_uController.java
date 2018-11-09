package uta.macross.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import uta.macross.entry.cardClothingFighter;
import uta.macross.entry.un_lock;
import uta.macross.service.Card_uService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/card_u")
public class Card_uController {
    @Autowired
    public Card_uService card_uService;
    @RequestMapping(value = "/getAllCard",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllCard(int i,int star,@RequestParam("opus[]") List<Integer>  opus,@RequestParam("attr[]") List<Integer>  attr,@RequestParam("singer[]") List<Integer>  singer,Integer clothing,Integer fighter,Integer skillCenter,Integer skillLive,Integer skillAction) {

        int start = i*10-10;
        int end = i*10;
//        List<Integer> attr = new ArrayList<Integer>();
//        List<Integer> opus= new ArrayList<Integer>();
//        Integer fighter=0;
//        Integer clothing=0;
//      Integer star=0;
//        List<Integer> singer= new ArrayList<Integer>();
        List<HashMap<String,Object>> list = card_uService.getAllCard(attr,opus,fighter,clothing,star,start,end,singer,skillCenter,skillLive,skillAction);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res",list);
        return jsonObject.toJSONString();
    }
    @RequestMapping(value = "/getCardInfo",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getCardInfo(int id){
        JSONObject jsonObject = new JSONObject();
        un_lock cardType = card_uService.getCardType(id);
        HashMap<String,Object> card ;
        HashMap<String,Object> fighter =new HashMap<String, Object>();
        HashMap<String,Object> clothing =new HashMap<String, Object>();
        card = card_uService.getCard(id);
        if(cardType.getU_Clothing()!=0){
            clothing = card_uService.getCardC(id);
        }else {
            fighter = card_uService.getCardF(id);
        }
        HashMap<String,Object> skill;
        skill = card_uService.getSkillByType((String) card.get("Card_I_C_S"));
        card.put("Card_I_C_S",skill.get("Skill_C"));
        card.put("Card_M_C_S",skill.get("Skill_C_max"));
        skill = card_uService.getSkillByType((String) card.get("Card_I_L_S"));
        card.put("Card_I_L_S",skill.get("Skill_C"));
        card.put("Card_M_L_S",skill.get("Skill_C_max"));
        skill = card_uService.getSkillByType((String) card.get("Card_I_A_S"));
        card.put("Card_I_A_S",skill.get("Skill_C"));
        card.put("Card_M_A_S",skill.get("Skill_C_max"));
        List<HashMap<String,Object>> singer=card_uService.getSingerByCard(id);
        jsonObject.put("fighter",fighter);
        jsonObject.put("clothing",clothing);
        jsonObject.put("card",card);
        jsonObject.put("singer",singer);
        return jsonObject.toJSONString();
    }
}