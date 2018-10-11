package uta.macross.service;

import uta.macross.entry.attribute;

import java.util.List;

public interface AttrService {
    //添加属性
    public int addAttr(attribute attr);
    //搜索所有属性
    public List<attribute> queryAllAttr();
}
