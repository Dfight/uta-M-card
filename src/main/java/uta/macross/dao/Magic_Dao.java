package uta.macross.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import uta.macross.entry.*;

@Repository
public interface Magic_Dao {
    //根据卡名获取卡,用于爬虫后判断本卡是否已有
    public card existCardByName(String name);
    //根据属性名获取属性编号
    public attribute getAttrIdByAttrName(String name);
    //根据解锁物名判断收否已收录
    public un_lock existUnlockByName(String name);
    //添加一个解锁物
    public int addUnlock(un_lock unlock);
    //添加一个卡与解锁物的关联
    public int addCardUnlock(card_unlock card_unlock);
    //根据技能效果判断技能是否已收录,如果是,则返回ID
    public skill getSkillIdByEffect(@Param("effect_I") String effect_I , @Param("effect_M") String effect_M);
    //自动添加技能
    public int addSkillAuto(skill skill);
    //获取对应位置待定类型
    public skill_type getSkillToDoType(String pos);
    //添加一个待定位置
    public int addSkillToDoType(skill_type skill_type);
    //根据歌姬姓名获取ID
    public singer getSingerIdByName(String name);
    //获取作品 待定 ID
    public opus getToDoOpus();
    //根据衣服名判断是否已收录
    public clothing existClothing(@Param("name") String name,@Param("singer") String singer);
    //修改unlock,绑定衣服飞机
    public int updateUnlock(un_lock un_lock);
    //根据衣服名判断是否已收录
    public fighter existFighter(String name);
}
