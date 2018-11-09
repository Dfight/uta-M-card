package uta.macross.piprline;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import uta.macross.entry.un_lock;
import uta.macross.service.Magic_Service;

import javax.annotation.Resource;

@Component("unlockPiprline")
public class unlockPiprline  implements Pipeline{
    @Resource
    private Magic_Service magic_service;
    public void process(ResultItems resultItems, Task task) {
        String name = resultItems.get("name");
        String img = resultItems.get("img");
        int i = magic_service.existUnlockByName(name);
        if (i==0){
            un_lock unlock = new un_lock();
            unlock.setU_Name(name);
            unlock.setU_IMG(img);
            magic_service.addUnlock(unlock);
        }
    }
}
