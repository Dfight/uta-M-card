package uta.macross.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.Spider;
import uta.macross.entry.*;
import uta.macross.service.CardService;
import uta.macross.util.cardPageProcessor;
import uta.macross.util.cardPiprline;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/card")
public class CardController {
    @Autowired
    public CardService cardService;
    @RequestMapping("/addCard")
    @ResponseBody
    public String addCard(String cardName, String opus, String attr, String fighter, String clothing, String init, String max,@RequestParam("singer[]") List<String>  singer){
        //创建相关对象
        JSONObject jsonObject = new JSONObject();
        int id;
        card card = new card();
        opus_card opusCard = new opus_card();
        attrCard attrCard = new attrCard();
        cardClothingFighter cardClothingFighter = new cardClothingFighter();
        JSONObject INIT  = JSON.parseObject(init);
        cardInit cardInit = json2class_init(INIT);
        JSONObject MAX = JSON.parseObject(max);
        cardMax cardMax =json2class_max(MAX);
        singer_card singerCard = new singer_card();

        //添加卡片,并得到卡面ID
        card.setCard_Name(cardName);
        cardService.addCard(card);
        id = card.getCard_ID();
        //添加作品
        opusCard.setO_Card_CID(id);
        opusCard.setO_Card_OID(Integer.parseInt(opus));
        cardService.addCardOpus(opusCard);
        //添加属性
        attrCard.setAc_aid(Integer.parseInt(attr));
        attrCard.setAc_cid(id);
        cardService.addCardAttr(attrCard);
        //绑定飞机或衣服
        cardClothingFighter.setC_C_F_Card(id);
        cardClothingFighter.setC_C_F_Clothing(Integer.parseInt(clothing));
        cardClothingFighter.setC_C_F_Fighter(Integer.parseInt(fighter));
        if(clothing.equals("0")){
            cardService.addCardFighter(cardClothingFighter);
        }else{
            cardService.addCardClothing(cardClothingFighter);
        }
        //添加初期属性
        cardInit.setCard_ID(id);
        cardService.addCardInit(cardInit);
        //添加满级信息
        cardMax.setCard_ID(id);
        cardService.addCardMax(cardMax);
        //添加歌姬相性信息
        singerCard.setSinger_Card_CID(id);
        for (int i = 0;i<singer.size();i++){
            singerCard.setSinger_Card_SID(Integer.parseInt((String)singer.get(i)));
            cardService.addCardSinger(singerCard);
        }


        return jsonObject.toJSONString();
    }
    public cardInit json2class_init(JSONObject jsonObject){
        cardInit cardInit = new cardInit();
        String initIMG = (String)jsonObject.get("initIMG");
        int initStar = (Integer) jsonObject.get("initStar");
        int initTotal = Integer.parseInt((String)jsonObject.get("initTotal"));
        int initSoul = Integer.parseInt((String)jsonObject.get("initSoul"));
        int initVoice = Integer.parseInt((String)jsonObject.get("initVoice"));
        int initCharm = Integer.parseInt((String)jsonObject.get("initCharm"));
        int initLife = Integer.parseInt((String)jsonObject.get("initLife"));
        int initSupport = Integer.parseInt((String)jsonObject.get("initSupport"));
        int initFoldWave = Integer.parseInt((String)jsonObject.get("initFoldWave"));
        int initLuck = Integer.parseInt((String)jsonObject.get("initLuck"));
        String initASkill = (String)jsonObject.get("initASkill");
        String initCSkill = (String)jsonObject.get("initCSkill");
        String initLSkill = (String)jsonObject.get("initLSkill");
        cardInit.setCard_I_IMG(initIMG);
        cardInit.setCard_I_Star(initStar);
        cardInit.setCard_I_Total(initTotal);
        cardInit.setCard_I_Soul(initSoul);
        cardInit.setCard_I_Voice(initVoice);
        cardInit.setCard_I_Charm(initCharm);
        cardInit.setCard_I_Life(initLife);
        cardInit.setCard_I_Support(initSupport);
        cardInit.setCard_I_FoldWave(initFoldWave);
        cardInit.setCard_I_Luck(initLuck);
        cardInit.setCard_I_A_S(initASkill);
        cardInit.setCard_I_C_S(initCSkill);
        cardInit.setCard_I_L_S(initLSkill);
        return cardInit;
    }
    public cardMax json2class_max(JSONObject jsonObject){
        cardMax cardMax = new cardMax();
        String maxIMG = (String)jsonObject.get("maxIMG");
        int maxStar = (Integer) jsonObject.get("maxStar");
        int maxTotal = Integer.parseInt((String)jsonObject.get("maxTotal"));
        int maxSoul = Integer.parseInt((String)jsonObject.get("maxSoul"));
        int maxVoice = Integer.parseInt((String)jsonObject.get("maxVoice"));
        int maxCharm = Integer.parseInt((String)jsonObject.get("maxCharm"));
        int maxLife = Integer.parseInt((String)jsonObject.get("maxLife"));
        int maxSupport = Integer.parseInt((String)jsonObject.get("maxSupport"));
        int maxFoldWave = Integer.parseInt((String)jsonObject.get("maxFoldWave"));
        int maxLuck = Integer.parseInt((String)jsonObject.get("maxLuck"));
        String maxASkill = (String)jsonObject.get("maxASkill");
        String maxCSkill = (String)jsonObject.get("maxCSkill");
        String maxLSkill = (String)jsonObject.get("maxLSkill");
        cardMax.setCard_M_IMG(maxIMG);
        cardMax.setCard_M_Star(maxStar);
        cardMax.setCard_M_Total(maxTotal);
        cardMax.setCard_M_Soul(maxSoul);
        cardMax.setCard_M_Voice(maxVoice);
        cardMax.setCard_M_Charm(maxCharm);
        cardMax.setCard_M_Life(maxLife);
        cardMax.setCard_M_Support(maxSupport);
        cardMax.setCard_M_FoldWave(maxFoldWave);
        cardMax.setCard_M_Luck(maxLuck);
        cardMax.setCard_M_A_S(maxASkill);
        cardMax.setCard_M_C_S(maxCSkill);
        cardMax.setCard_M_L_S(maxLSkill);
        return cardMax;
    }

    @Qualifier("cardPiprline")
    @Autowired
    private cardPiprline cardPiprline ;


    @RequestMapping("/webmagic")
    @ResponseBody
    public String webmagic(){
        Spider.create(new cardPageProcessor()).
                addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/最新情報_ガチャ情報")
                //addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/プレート_Welcome%20to%20Walküre%20World")
                .addPipeline(cardPiprline)
                .thread(5)
                .run();
       return null;
    }
}