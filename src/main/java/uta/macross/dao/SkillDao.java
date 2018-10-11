package uta.macross.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface SkillDao {
    public int addSkill(HashMap<String,Object> map);
    public List<HashMap<String,Object>> getAllSkill();
    public int addSkillType(HashMap<String,Object> map);
    public List<HashMap<String,Object>> getSkillTypeByPos(String pos);
}
