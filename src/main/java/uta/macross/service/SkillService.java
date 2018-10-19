package uta.macross.service;

import uta.macross.entry.skill;
import uta.macross.entry.skill_type;

import java.util.HashMap;
import java.util.List;

public interface SkillService {
    public int addSkill(HashMap<String,Object> map);
    public List<HashMap<String,Object>> getAllSkill();
    public int addSkillType(skill_type skill_type);
    public List<HashMap<String,Object>> getSkillTypeByPos(String pos);
    public List<skill_type> getSkillType();
    public List<skill> getSkillByType(String type);
}
