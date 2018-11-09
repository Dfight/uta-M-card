package uta.macross.util;

import us.codecraft.webmagic.Spider;
import uta.macross.piprline.cardPiprline;
import uta.macross.processor.cardPageProcessor;

public class test {
    uta.macross.piprline.cardPiprline cardPiprline = new cardPiprline();
    public static void main(String[] args) {
        Spider.create(new cardPageProcessor()).
                addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/プレート_Welcome%20to%20Walküre%20World")
                .addPipeline(new cardPiprline())
                .thread(5)
                .run();
    }
}
