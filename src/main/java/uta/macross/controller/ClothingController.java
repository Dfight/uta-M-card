package uta.macross.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uta.macross.entry.clothing;
import uta.macross.entry.singer_clothing;
import uta.macross.service.ClothingService;

import java.util.List;

@Controller
@RequestMapping("/clothing")
public class ClothingController {
    @Autowired
    public ClothingService clothingService;
    @RequestMapping(value = "/addClothing",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addClothing(String clothingName,String clothingIMG,String clothingFeatures,int clothingSinger){
        clothing s = new clothing();
        s.setClothing_Name(clothingName);
        s.setClothing_Features(clothingFeatures);
        s.setClothing_IMG(clothingIMG);
        clothingService.addClothing(s);
        singer_clothing sc = new singer_clothing();
        sc.setSinger_Clothing_CID(s.getClothing_ID());
        sc.setSinger_Clothing_SID(clothingSinger);
        clothingService.addClothingSinger(sc);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",1);
        return jsonObject.toJSONString();
    }
    @RequestMapping(value = "/queryAllClothing",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String queryAllClothing(){
        List<clothing> list = clothingService.queryAllClothing();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res",list);
        return jsonObject.toJSONString();
    }
    @RequestMapping(value = "/queryClothingSinger",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String queryClothingSinger(int clothing ){
        int singer= clothingService.queryClothingSinger(clothing);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res",singer);
        return jsonObject.toJSONString();
    }
}
