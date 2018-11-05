package uta.macross.service;

import org.springframework.stereotype.Repository;
import uta.macross.entry.card_unlock;
import uta.macross.entry.skill;
import uta.macross.entry.un_lock;

@Repository
public interface Magic_Service {
    //根据卡名获取卡,用于爬虫后判断本卡是否已有
    public boolean existCardByName(String name);
    //根据属性名获取属性编号
    public int getAttrIdByAttrName(String name);
    //根据解锁物名判断收否已收录,如已收录,则返回id
    public int existUnlockByName(String name);
    //添加一个解锁物
    public int addUnlock(un_lock unlock);
    //添加一个卡与解锁物的关联
    public int addCardUnlock(card_unlock card_unlock);
    //根据技能效果判断技能是否已收录,如果是,则返回ID
    public int getSkillIdByEffect(String effect_I,String effect_M);
    //自动添加技能
    public int addSkillAuto(skill skill);
    //获取对应位置待定类型
    public int getSkillToDoType(String pos);
    //根据歌姬姓名获取ID
    public int getSingerIdByName(String name);
    //获取作品 待定 ID
    public int getToDoOpus();
}
