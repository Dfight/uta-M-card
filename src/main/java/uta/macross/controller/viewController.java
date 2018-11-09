package uta.macross.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view")
public class viewController {

    @RequestMapping("/login")
    @ResponseBody
    public String login(String name,String pass){
        JSONObject js = new JSONObject();
       if (name.equals("root")){
           js.put("result","1");
       }else{
           js.put("result","2");
       }
       return js.toJSONString();
    }
    @RequestMapping("/toMain")
    @ResponseBody
    public ModelAndView toMain(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        return modelAndView;
    }
    @RequestMapping("/singer")
    @ResponseBody
    public ModelAndView singer(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/Singer");
        return modelAndView;
    }
    @RequestMapping("/opus")
    @ResponseBody
    public ModelAndView opus(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/Opus");
        return modelAndView;
    }
    @RequestMapping("/attribute")
    @ResponseBody
    public ModelAndView attribute(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/Attribute");
        return modelAndView;
    }
    @RequestMapping("/difficult")
    @ResponseBody
    public ModelAndView difficult(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/Difficult");
        return modelAndView;
    }
    @RequestMapping("/addSong")
    @ResponseBody
    public ModelAndView addSong(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("song/AddSong");
        return modelAndView;
    }
    @RequestMapping("/editSong")
    @ResponseBody
    public ModelAndView editSong(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("song/EditSong");
        return modelAndView;
    }
    @RequestMapping("/fighter")
    @ResponseBody
    public ModelAndView fighter(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fighterAndClothing/fighter");
        return modelAndView;
    }
    @RequestMapping("/clothing")
    @ResponseBody
    public ModelAndView clothing(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fighterAndClothing/clothing");
        return modelAndView;
    }
    @RequestMapping("/cardOpus")
    @ResponseBody
    public ModelAndView cardOpus(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bind/cardOpus");
        return modelAndView;
    }
    @RequestMapping("/fighterOpus")
    @ResponseBody
    public ModelAndView fighterOpus(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bind/fighterOpus");
        return modelAndView;
    }
    @RequestMapping("/skill")
    @ResponseBody
    public ModelAndView skill(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/Skill");
        return modelAndView;
    }
    @RequestMapping("/test")
    @ResponseBody
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test/test");
        return modelAndView;
    }
}
