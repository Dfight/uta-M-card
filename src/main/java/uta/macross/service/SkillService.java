package uta.macross.service;

import java.util.HashMap;
import java.util.List;

public interface SkillService {
    public int addSkill(HashMap<String,Object> map);
    public List<HashMap<String,Object>> getAllSkill();
    public int addSkillType(HashMap<String,Object> map);
    public List<HashMap<String,Object>> getSkillTypeByPos(String pos);
}
