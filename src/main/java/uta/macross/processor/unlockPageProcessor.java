package uta.macross.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class unlockPageProcessor implements PageProcessor{
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    public void process(Page page) {
        if (page.getHtml().xpath("//div[@class='page']/h1/text()").toString().equals("エピソード")){
            List<String> urls = page.getHtml().xpath("//table[@id=content_block_5]").links().all();
            page.addTargetRequests(urls);
            page.setSkip(true);
        }else {
            page.putField("name",page.getHtml().xpath("//div[@class='page']/h1/text()").toString());
            page.putField("img",page.getHtml().xpath("//div[@class='user-area']/div/img/@src").toString().substring(73));

        }
    }

    public Site getSite() {
        return site;
    }
}
