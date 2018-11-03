package uta.macross.service;

import org.springframework.stereotype.Repository;
import uta.macross.entry.unlock;

@Repository
public interface Magic_Service {
    //根据卡名获取卡,用于爬虫后判断本卡是否已有
    public boolean existCardByName(String name);
    //根据属性名获取属性编号
    public int getAttrIdByAttrName(String name);
    //根据解锁物名判断收否已收录,如已收录,则返回id
    public int existUnlockByName(String name);
    //添加一个解锁物
    public int addUnlock(unlock unlock);
}
