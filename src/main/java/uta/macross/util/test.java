package uta.macross.util;

import us.codecraft.webmagic.Spider;

public class test {
    cardPiprline cardPiprline = new cardPiprline();
    public static void main(String[] args) {
        Spider.create(new cardPageProcessor()).
                addUrl("https://歌マクロス.gamematome.jp/game/977/wiki/プレート_空中の救出劇")
                .addPipeline(new cardPiprline())
                .thread(5)
                .run();
    }
}
