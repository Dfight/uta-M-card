package uta.macross.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uta.macross.dao.SkillDao;
import uta.macross.entry.skill;
import uta.macross.entry.skill_type;
import uta.macross.service.SkillService;

import java.util.HashMap;
import java.util.List;
@Service("skillService")
public class SkillServiceImpl implements SkillService {
    @Autowired
    public SkillDao skillDao;
    public int addSkill(HashMap<String, Object> map) {
        return skillDao.addSkill(map);
    }

    public List<HashMap<String, Object>> getAllSkill() {
        return skillDao.getAllSkill();
    }

    public int addSkillType(skill_type skill_type) {
        return skillDao.addSkillType(skill_type);
    }

    public List<HashMap<String, Object>> getSkillTypeByPos(String pos) {
        return skillDao.getSkillTypeByPos(pos);
    }

    public List<skill_type> getSkillType() {
        return skillDao.getSkillType();
    }

    public List<skill> getSkillByType(String type) {
        return skillDao.getSkillByType(type);
    }
}
