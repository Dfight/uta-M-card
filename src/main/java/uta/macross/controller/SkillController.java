package uta.macross.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uta.macross.entry.skill;
import uta.macross.entry.skill_type;
import uta.macross.service.SkillService;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    public SkillService skillService;

    @RequestMapping(value = "/getSkillType",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getSkillType(){
        JSONObject jsonObject =new JSONObject();
        List<skill_type> list = skillService.getSkillType();
        jsonObject.put("res",list);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/getSkillTypeByPos",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getSkillTypeByPos(String pos){
        JSONObject jsonObject =new JSONObject();
        List<HashMap<String, Object>> list = skillService.getSkillTypeByPos(pos);
        jsonObject.put("res",list);
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/addSkill",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addSkill(String pos,String type,String otherType,String lv,String skill_J,String skill_J_max,String skill_C,String skill_C_max){
        JSONObject jsonObject =new JSONObject();
        HashMap<String,Object> map = new HashMap<String,Object>();
        skill_type skill_type = new skill_type();
        if(skill_C.equals("") || skill_C == null){
            skill_C = skill_J;
        }
        if(skill_C_max.equals("") || skill_C_max == null){
            skill_C_max = skill_J_max;
        }
        skill_type.setPos(pos);
        skill_type.setType(otherType);
        map.put("Skill_LV",lv);
        map.put("Skill_J",skill_J);
        map.put("Skill_J_max",skill_J_max);
        map.put("Skill_C",skill_C);
        map.put("Skill_C_max",skill_C_max);
        if(type.equals("99999")){
            int i= skillService.addSkillType(skill_type);
            if(i!=1){
                jsonObject.put("res","false");
                return jsonObject.toJSONString();
            }
            map.put("Skill_Type",skill_type.getId());
        }else{
            map.put("Skill_Type",type);
        }

        int i = skillService.addSkill(map);
        if(i!=1){
            jsonObject.put("res","false");
            return jsonObject.toJSONString();
        }
        jsonObject.put("res","true");
        return jsonObject.toJSONString();
    }
    @RequestMapping(value = "/getSkillByType",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getSkillByType(String type){
        JSONObject jsonObject = new JSONObject();
        List<skill> skill = skillService.getSkillByType(type);
        jsonObject.put("res",skill);
        return jsonObject.toJSONString();
    }
}
