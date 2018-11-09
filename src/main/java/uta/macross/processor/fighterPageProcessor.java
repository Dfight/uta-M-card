package uta.macross.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class fighterPageProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    public void process(Page page) {
        if (page.getHtml().xpath("//div[@class='page']/h1/text()").toString().equals("バルキリー")){
            List<String> urls = page.getHtml().xpath("//table[@id=content_block_3]").links().all();
            page.addTargetRequests(urls);
            page.setSkip(true);
        }else {
            page.putField("name",page.getHtml().xpath("//div[@class='page']/h1/text()").toString());
            page.putField("driver",page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr[2]/td[2]/text()").toString());
            page.putField("attack",page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr[3]/td[2]/text()").toString());
            page.putField("hit",page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr[4]/td[2]/text()").toString());
            page.putField("unlock",page.getHtml().xpath("//table[@id='content_block_3']/tbody/tr[5]/td[2]/a/text()").toString());
            page.putField("img",page.getHtml().xpath("//div[@class=user-area]/div/img/@src").toString().substring(73));
        }
    }

    public Site getSite() {
        return site;
    }
}
