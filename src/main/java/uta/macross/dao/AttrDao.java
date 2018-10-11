package uta.macross.dao;

import org.springframework.stereotype.Repository;
import uta.macross.entry.attribute;

import java.util.List;

@Repository
public interface AttrDao {
    //添加属性
    public int addAttr(attribute attr);
    //获取所有属性信息
    public List<attribute> queryAllAttr();
}
