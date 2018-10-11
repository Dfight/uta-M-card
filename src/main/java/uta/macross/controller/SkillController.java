package uta.macross.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uta.macross.service.SkillService;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    public SkillService skillService;
    @RequestMapping(value = "/addSkill",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addSkill(){
        JSONObject jsonObject =new JSONObject();

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
}
