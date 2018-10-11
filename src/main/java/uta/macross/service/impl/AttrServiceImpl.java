package uta.macross.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uta.macross.dao.AttrDao;
import uta.macross.entry.attribute;
import uta.macross.service.AttrService;

import java.util.List;

@Service("attrService")
public class AttrServiceImpl implements AttrService{
    @Autowired
    public AttrDao attrDao;
    public int addAttr(attribute attr) {
        return attrDao.addAttr(attr);
    }

    public List<attribute> queryAllAttr() {
        return attrDao.queryAllAttr();
    }
}
