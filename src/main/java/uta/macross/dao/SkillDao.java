package uta.macross.dao;

import org.springframework.stereotype.Repository;
import uta.macross.entry.skill;
import uta.macross.entry.skill_type;

import java.util.HashMap;
import java.util.List;

@Repository
public interface SkillDao {
    public int addSkill(HashMap<String,Object> map);
    public List<HashMap<String,Object>> getAllSkill();
    public int addSkillType(skill_type skill_type);
    public List<HashMap<String,Object>> getSkillTypeByPos(String pos);
    public List<skill_type> getSkillType();
    public List<skill> getSkillByType(String type);
}
