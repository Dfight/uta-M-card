package uta.macross.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uta.macross.dao.Magic_Dao;
import uta.macross.entry.*;
import uta.macross.service.Magic_Service;
@Service("magic_Service")
public class Magic_ServiceImpl implements Magic_Service{
    @Autowired
    public Magic_Dao magic_dao;
    public boolean existCardByName(String name) {
        card card = magic_dao.existCardByName(name);
        if (card!=null){
            return true;
        }else{
            return false;
        }
    }

    public int getAttrIdByAttrName(String name) {
        attribute attr = magic_dao.getAttrIdByAttrName(name);
        return attr.getAttr_ID();
    }

    public int existUnlockByName(String name) {
        un_lock unlock = magic_dao.existUnlockByName(name);
        if (unlock ==null){
            return 0;
        }else{
            return unlock.getU_ID();
        }
    }

    public int addUnlock(un_lock un_lock) {
        return magic_dao.addUnlock(un_lock);
    }

    public int addCardUnlock(card_unlock card_unlock) {
        return magic_dao.addCardUnlock(card_unlock);
    }


    public int getSkillIdByEffect(String effect_I,String effect_M) {
        skill skill = magic_dao.getSkillIdByEffect(effect_I, effect_M);
        if (skill==null){
            return 0;
        }else{
            return skill.getSkill_ID();
        }
    }

    public int addSkillAuto(skill skill) {
        return magic_dao.addSkillAuto(skill);
    }

    public int getSkillToDoType(String pos) {
        skill_type skilltype = magic_dao.getSkillToDoType(pos);
        if (skilltype==null){
            skilltype.setPos(pos);
            skilltype.setType("待定");
            magic_dao.addSkillToDoType(skilltype);
        }
        return skilltype.getId();
    }

    public int getSingerIdByName(String name) {
        singer singer = magic_dao.getSingerIdByName(name);
        return singer.getSinger_ID();
    }
    //获取作品 待定 ID
    public int getToDoOpus(){
        opus opus = magic_dao.getToDoOpus();
        return opus.getOpus_ID();
    }
}
