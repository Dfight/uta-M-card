package uta.macross.piprline;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import uta.macross.entry.fighter;
import uta.macross.entry.un_lock;
import uta.macross.service.FighterService;
import uta.macross.service.Magic_Service;

import javax.annotation.Resource;

@Component("fighterPiprline")
public class fighterPiprline implements Pipeline {
    @Resource
    private Magic_Service magic_service;
    @Resource
    private FighterService fighterService;
    public void process(ResultItems resultItems, Task task) {
        String name = resultItems.get("name");
        String driver = resultItems.get("driver");
        int attack = Integer.parseInt((String)resultItems.get("attack"));
        int hit =Integer.parseInt((String)resultItems.get("hit"));
        String img = resultItems.get("img");
        String unlock = resultItems.get("unlock");

        boolean existFighter = magic_service.existFighter(name);
        if(!existFighter){
            fighter fighter = new fighter();
            fighter.setFighter_IMG(img);
            fighter.setFighter_Hit(hit);
            fighter.setFighter_Attack(attack);
            fighter.setFighter_Driver(driver);
            fighter.setFighter_Name(name);
            fighterService.addFighter(fighter);
            if (unlock!=null&&!unlock.equals("")){
                unlock = unlock.split("」")[0].substring(1);
                int unlockId = magic_service.existUnlockByName(unlock);
                un_lock un_lock = new un_lock();
                un_lock.setU_Name(unlock);
                un_lock.setU_ID(unlockId);
                un_lock.setU_Fighter(fighter.getFighter_ID());
                magic_service.updateUnlock(un_lock);
            }
        }

    }
}
