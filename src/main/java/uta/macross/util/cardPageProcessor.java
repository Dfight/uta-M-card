package uta.macross.util;


import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import uta.macross.entry.card;
import uta.macross.entry.cardInit;
import uta.macross.entry.cardMax;
import uta.macross.entry.skill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cardPageProcessor  implements PageProcessor{
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    public void process(Page page) {
        //初始化相关实体
        card card = new card();
        cardInit cardInit = new cardInit();
        cardMax cardMax = new cardMax();
        Map<String,skill> skill= new HashMap<String,skill>();
        skill center = new skill();
        skill action = new skill();
        skill live = new skill();
        List<String> singer = new ArrayList<String>();
        if (page.getHtml().xpath("//div[@class='page']/h1/text()").toString().equals("ガチャ情報")){
            page.setSkip(true);
        }else {
            //筛选卡基础信息相关内容
            card.setCard_Name(page.getHtml().xpath("//div[@class='page']/h1/text()").toString());
            cardInit.setCard_I_IMG(page.getHtml().xpath("//table[@id='content_block_2']/tbody/tr[1]/td[1]/div/img/@src").toString().substring(73));
            cardMax.setCard_M_IMG(page.getHtml().xpath("//table[@id='content_block_2']/tbody/tr[1]/td[2]/div/img/@src").toString().substring(73));
            cardInit.setCard_I_Star(page.getHtml().xpath("//table[@id='content_block_2']/tbody/tr[2]/td[1]/div/text()").toString().length());
            cardMax.setCard_M_Star(page.getHtml().xpath("//table[@id='content_block_2']/tbody/tr[2]/td[2]/div/text()").toString().length());

            //筛选卡初期信息
            cardInit.setCard_I_Total(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[2]/td[2]/text()").toString()));
            cardInit.setCard_I_Soul(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[2]/td[3]/text()").toString()));
            cardInit.setCard_I_Voice(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[2]/td[4]/text()").toString()));
            cardInit.setCard_I_Charm(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[2]/td[5]/text()").toString()));
            cardInit.setCard_I_Life(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_14']/tbody/tr[2]/td[2]/text()").toString()));
            cardInit.setCard_I_Support(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[2]/td[3]/text()").toString()));
            cardInit.setCard_I_FoldWave(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[2]/td[4]/text()").toString()));
            cardInit.setCard_I_Luck(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[2]/td[5]/text()").toString()));
            //筛选卡满级信息
            cardMax.setCard_M_Total(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[3]/td[2]/text()").toString()));
            cardMax.setCard_M_Soul(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[3]/td[3]/text()").toString()));
            cardMax.setCard_M_Voice(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[3]/td[4]/text()").toString()));
            cardMax.setCard_M_Charm(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[3]/td[5]/text()").toString()));
            cardMax.setCard_M_Life(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_14']/tbody/tr[3]/td[2]/text()").toString()));
            cardMax.setCard_M_Support(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[3]/td[3]/text()").toString()));
            cardMax.setCard_M_FoldWave(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[3]/td[4]/text()").toString()));
            cardMax.setCard_M_Luck(Integer.parseInt(page.getHtml().xpath("//table[@id='content_block_11']/tbody/tr[3]/td[5]/text()").toString()));
            //筛选卡Center技能信息
            center.setSkill_J(page.getHtml().xpath("//table[@id='content_block_19']/tbody/tr[1]/td[2]/text()").toString());
            center.setSkill_J_max(page.getHtml().xpath("//table[@id='content_block_19]/tbody/tr[2]/td[2]/text()").toString());
            skill.put("Center", center);
            //筛选卡Action技能信息
            action.setSkill_J(page.getHtml().xpath("//table[@id='content_block_24']/tbody/tr[1]/td[2]/text()").toString());
            action.setSkill_J_max(page.getHtml().xpath("//table[@id='content_block_24]/tbody/tr[2]/td[2]/text()").toString());
            skill.put("Action", action);
            //筛选卡Live技能信息
            live.setSkill_J(page.getHtml().xpath("//table[@id='content_block_29']/tbody/tr[1]/td[2]/text()").toString());
            live.setSkill_J_max(page.getHtml().xpath("//table[@id='content_block_29]/tbody/tr[2]/td[2]/text()").toString());
            skill.put("Live", live);
            //筛选相性歌姬信息
            singer = page.getHtml().xpath("//table[@id=content_block_33]/tbody/tr/td[2]/div/b/a/text()").all();

            page.putField("card", card);
            page.putField("init", cardInit);
            page.putField("max", cardMax);
            page.putField("attr", page.getHtml().xpath("//table[@id='content_block_6']/tbody/tr[1]/td[2]/text()").toString());
            page.putField("un_lock", page.getHtml().xpath("//table[@id='content_block_6']/tbody/tr[2]/td[2]/a/text()").toString());
            page.putField("skill", skill);
            page.putField("singer", singer);
        }
        List<String> urls = page.getHtml().xpath("//table[@id=content_block_4]").links().all();
        page.addTargetRequests(urls);
        //System.out.println(page.getHtml().xpath("//table[@id=content_block_4]").links().all().toString());
    }

    public Site getSite() {
        return site;
    }
}
