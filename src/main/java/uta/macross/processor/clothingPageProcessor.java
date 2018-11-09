package uta.macross.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import uta.macross.entry.clothing;
import uta.macross.entry.singer_clothing;

import java.util.HashMap;
import java.util.List;

public class clothingPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(5).setSleepTime(500);
    public void process(Page page) {
        if (page.getHtml().xpath("//div[@class='page']/h1/text()").toString().equals("衣装")){
            List<String> urls = page.getHtml().xpath("//table[@id=content_block_3]").links().all();
            page.addTargetRequests(urls);
            page.setSkip(true);
        }else {
            page.putField("name",page.getHtml().xpath("//div[@class='page']/h1/text()").toString());
            page.putField("singer",page.getHtml().xpath("//table[@id=content_block_3]/tbody/tr[1]/td[2]/a/text()").toString());
            page.putField("unlock",page.getHtml().xpath("//table[@id=content_block_3]/tbody/tr[2]/td[2]/a/text()").toString());
            page.putField("features",page.getHtml().xpath("//table[@id=content_block_3]/tbody/tr[3]/td[2]/text()").toString());
            page.putField("img",page.getHtml().xpath("//div[@class=user-area]/div/img/@src").toString().substring(73));
        }

    }

    public Site getSite() {
        return site;
    }
}
