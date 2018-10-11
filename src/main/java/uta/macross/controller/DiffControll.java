package uta.macross.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uta.macross.entry.difficulty;
import uta.macross.service.DiffService;

import java.util.List;

@Controller
@RequestMapping("/diff")
public class DiffControll {
    @Autowired
    public DiffService diffService;

    @RequestMapping(value = "/addDiff",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addDiff(String diffName,int diffConsume){
        difficulty diff = new difficulty();
        diff.setDiff_Consume(diffConsume);
        diff.setDiff_Diff(diffName);
        int i = diffService.addDiff(diff);
        JSONObject jsonObject = new JSONObject();
        if (i == 1) {
            jsonObject.put("code", 1);
        } else {
            jsonObject.put("msg", "添加难度失败");
        }
        return jsonObject.toJSONString();
    }
    @RequestMapping(value = "/queryAllDiff",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String queryAllDiff(){
        List<difficulty> list= diffService.queryAllDiff();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res",list);
        String jsString = jsonObject.toJSONString();
        return jsString;
    }

}
