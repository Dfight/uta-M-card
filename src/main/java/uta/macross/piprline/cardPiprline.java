package uta.macross.piprline;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import uta.macross.entry.*;
import uta.macross.service.CardService;
import uta.macross.service.Magic_Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component("cardPiprline")
public class cardPiprline implements Pipeline {
    @Resource
    private Magic_Service magic_service;
    @Resource
    private CardService cardService;
    //public CardService cardService = new CardServiceImpl();

    public void process(ResultItems resultItems, Task task) {
        //取出筛选完的数据
        card card = resultItems.get("card");
        cardInit init = resultItems.get("init");
        cardMax max = resultItems.get("max");
        String attr = resultItems.get("attr");
        String unlock = resultItems.get("un_lock");
        Map<String,skill> skill=(Map<String,skill>) resultItems.get("skill");
        List<String> singer = resultItems.get("singer");
        //判断此卡是否已收录
        boolean existCard = magic_service.existCardByName(card.getCard_Name());
        if(!existCard){
            //添加卡,记录返回的卡ID
            cardService.addCard(card);
            int ID = card.getCard_ID();
            //创建属性-卡关联对象
            attrCard attrCard = new attrCard();
            attrCard.setAc_aid(magic_service.getAttrIdByAttrName(attr));
            attrCard.setAc_cid(ID);
            cardService.addCardAttr(attrCard);
            //创建作品-卡关联对象,默认保存为待定
            opus_card opusCard = new opus_card();
            opusCard.setO_Card_CID(ID);
            opusCard.setO_Card_OID(magic_service.getToDoOpus());
            cardService.addCardOpus(opusCard);
            //判断解锁物是否已收录
            int unlickid = magic_service.existUnlockByName(unlock);
            //创建解锁物-卡关联对象
            card_unlock card_unlock = new card_unlock();
            card_unlock.setC_ID(ID);
            if (unlickid==0){
                //没有收录,添加一个
                un_lock Unlock = new un_lock();
                Unlock.setU_Name(unlock);
                magic_service.addUnlock(Unlock);
                card_unlock.setU_ID(Unlock.getU_ID());
            }else{
                //有收录
                card_unlock.setU_ID(unlickid);
            }
            magic_service.addCardUnlock(card_unlock);
            //根据技能位置和效果判断技能是否已收录,如果是,则返回ID
            skill center = skill.get("Center");
            skill action = skill.get("Action");
            skill live = skill.get("Live");
            //Center
            int skillCenterID = magic_service.getSkillIdByEffect(center.getSkill_J(),center.getSkill_C_max());
            if (skillCenterID==0){
                center.setSkill_Type(magic_service.getSkillToDoType("Center"));
                magic_service.addSkillAuto(center);
                skillCenterID = center.getSkill_ID();
            }
            init.setCard_I_C_S(Integer.toString(skillCenterID));
            max.setCard_M_C_S(Integer.toString(skillCenterID));
            //Action
            int skillActionID = magic_service.getSkillIdByEffect(action.getSkill_J(),action.getSkill_C_max());
            if (skillActionID==0){
                action.setSkill_Type(magic_service.getSkillToDoType("Action"));
                magic_service.addSkillAuto(action);
                skillActionID = action.getSkill_ID();
            }
            init.setCard_I_A_S(Integer.toString(skillActionID));
            max.setCard_M_A_S(Integer.toString(skillActionID));
            //Live
            int skillLiveID = magic_service.getSkillIdByEffect(live.getSkill_J(),live.getSkill_C_max());
            if (skillLiveID==0){
                live.setSkill_Type(magic_service.getSkillToDoType("Live"));
                magic_service.addSkillAuto(live);
                skillLiveID = live.getSkill_ID();
            }
            init.setCard_I_L_S(Integer.toString(skillLiveID));
            max.setCard_M_L_S(Integer.toString(skillLiveID));
            //添加卡初期信息
            init.setCard_ID(ID);
            cardService.addCardInit(init);
            //添加卡满级信息
            max.setCard_ID(ID);
            cardService.addCardMax(max);
            //添加歌姬相性相关
            for (int i=0;i<singer.size();i++){
                String singerName = singer.get(i);
                int singerID = magic_service.getSingerIdByName(singerName);
                singer_card singer_card = new singer_card();
                singer_card.setSinger_Card_CID(ID);
                singer_card.setSinger_Card_SID(singerID);
                cardService.addCardSinger(singer_card);
            }
        }
    }
}