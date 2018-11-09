package uta.macross.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.Spider;
import uta.macross.piprline.cardPiprline;
import uta.macross.piprline.clothingPiprline;
import uta.macross.piprline.fighterPiprline;
import uta.macross.piprline.unlockPiprline;
import uta.macross.processor.cardPageProcessor;
import uta.macross.processor.clothingPageProcessor;
import uta.macross.processor.fighterPageProcessor;
import uta.macross.processor.unlockPageProcessor;

@Controller
@RequestMapping("/webmagic")
public class webmagicController {

    @Qualifier("cardPiprline")
    @Autowired
    private uta.macross.piprline.cardPiprline cardPiprline ;
    @RequestMapping("/card")
    @ResponseBody
    public String card(){
        Spider.create(new cardPageProcessor()).
                addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/プレート")
                //addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/最新情報_ガチャ情報")
                //addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/プレート_輝く明日への想い")
                .addPipeline(cardPiprline)
                .thread(5)
                .run();
        return null;
    }

    @Qualifier("clothingPiprline")
    @Autowired
    private uta.macross.piprline.clothingPiprline clothingPiprline ;
    @RequestMapping("/clothing")
    @ResponseBody
    public String clothing(){
        Spider.create(new clothingPageProcessor()).
                addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/歌姫_衣装")
                //addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/歌姫_衣装_シェリル・ノーム_カウントベイビー")
                //addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/歌姫_衣装_フレイア・ヴィオン_ワルキューレ・ユニフォーム")
                .addPipeline(clothingPiprline)
                .thread(10)
                .run();
        return null;
    }

    @Qualifier("unlockPiprline")
    @Autowired
    private unlockPiprline unlockPiprline ;
    @RequestMapping("/unlock")
    @ResponseBody
    public String unlock(){
        Spider.create(new unlockPageProcessor()).
                addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/エピソード")
                //addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/エピソード_夏が待ちきれなくて")
                .addPipeline(unlockPiprline)
                .thread(5)
                .run();
        return null;
    }

    @Qualifier("fighterPiprline")
    @Autowired
    private fighterPiprline fightPiprline ;
    @RequestMapping("/fighter")
    @ResponseBody
    public String fighter(){
        Spider.create(new fighterPageProcessor()).
                addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/バルキリー")
                // addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/バルキリー_マクロスΔ_VF-31E")
                .addPipeline(fightPiprline)
                .thread(5)
                .run();
        return null;
    }
}
