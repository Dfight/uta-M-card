package uta.macross.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uta.macross.entry.attribute;
import uta.macross.service.AttrService;

import java.util.List;

@Controller
@RequestMapping("/attr")
public class AttrController {
    @Autowired
    public AttrService attrService;
    @RequestMapping("/addAttr")
    @ResponseBody
    public String addAttr(String attrName,String attrIMG){
        attribute attr = new attribute();
        attr.setAttr_Name(attrName);
        attr.setAttr_IMG(attrIMG);
        int i = attrService.addAttr(attr);
        JSONObject jsonObject = new JSONObject();
        if (i == 1) {
            jsonObject.put("code", 1);
        } else {
            jsonObject.put("msg", "添加属性失败");
        }
        return jsonObject.toJSONString();
    }
    @RequestMapping(value = "/queryAllAttr",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String queryAllAttr(){
        List<attribute> list= attrService.queryAllAttr();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res",list);
        String jsString = jsonObject.toJSONString();
        return jsString;
    }
}
