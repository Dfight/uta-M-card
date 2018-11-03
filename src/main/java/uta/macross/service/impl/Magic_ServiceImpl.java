package uta.macross.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uta.macross.dao.Magic_Dao;
import uta.macross.entry.attribute;
import uta.macross.entry.card;
import uta.macross.entry.unlock;
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
        unlock unlock = magic_dao.existUnlockByName(name);
        if (unlock==null){
            return 0;
        }else{
            return unlock.getU_Id();
        }
    }

    public int addUnlock(unlock unlock) {
        return magic_dao.addUnlock(unlock);
    }
}
