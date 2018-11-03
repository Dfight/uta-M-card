package uta.macross.dao;

import org.springframework.stereotype.Repository;
import uta.macross.entry.attribute;
import uta.macross.entry.card;
import uta.macross.entry.unlock;

@Repository
public interface Magic_Dao {
    //根据卡名获取卡,用于爬虫后判断本卡是否已有
    public card existCardByName(String name);
    //根据属性名获取属性编号
    public attribute getAttrIdByAttrName(String name);
    //根据解锁物名判断收否已收录
    public unlock existUnlockByName(String name);
    //添加一个解锁物
    public int addUnlock(unlock unlock);
}
