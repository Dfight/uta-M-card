package uta.macross.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import uta.macross.entry.*;
import uta.macross.service.CardService;
import uta.macross.service.Magic_Service;
import uta.macross.service.impl.CardServiceImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component("cardPiprline")
public class cardPiprline implements Pipeline {
    @Resource
    private Magic_Service magic_service;
    //public CardService cardService = new CardServiceImpl();

    public void process(ResultItems resultItems, Task task) {
        //取出筛选完的数据
        card card = resultItems.get("card");
        cardInit init = resultItems.get("init");
        cardMax max = resultItems.get("max");
        String attr = resultItems.get("attr");
        String unlock = resultItems.get("unlock");
        Map<String,skill> skill=(Map<String,skill>) resultItems.get("skill");
        List<String> singer = resultItems.get("singer");
        //判断此卡是否已收录
        boolean existCard = magic_service.existCardByName(card.getCard_Name());
        if(!existCard){
            //创建属性-卡关联对象
            attrCard attrCard = new attrCard();
            attrCard.setAc_aid(magic_service.getAttrIdByAttrName(attr));
            //判断解锁物是否已收录
            int unlickid = magic_service.existUnlockByName(unlock);
            //创建解锁物-卡关联对象
            card_unlock card_unlock = new card_unlock();
            if (unlickid==0){
                //没有收录,添加一个
                unlock Unlock = new unlock();
                Unlock.setU_Name(unlock);
                magic_service.addUnlock(Unlock);
                card_unlock.setU_ID(Unlock.getU_Id());
            }else{
                //有收录
                card_unlock.setU_ID(unlickid);
            }

        }
        System.out.println(card.getCard_Name()+"---"+existCard);
    }
}