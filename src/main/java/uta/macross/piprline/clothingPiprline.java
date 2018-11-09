package uta.macross.piprline;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import uta.macross.entry.clothing;
import uta.macross.entry.singer_clothing;
import uta.macross.entry.un_lock;
import uta.macross.service.ClothingService;
import uta.macross.service.Magic_Service;
import uta.macross.service.SingerService;

import javax.annotation.Resource;

@Component("clothingPiprline")
public class clothingPiprline implements Pipeline {
    @Resource
    private ClothingService clothingService;
    @Resource
    private Magic_Service magic_service;
    public void process(ResultItems resultItems, Task task) {
        String name = resultItems.get("name");
        String singer = resultItems.get("singer");
        String features = resultItems.get("features");
        String img = resultItems.get("img");
        String unlock = resultItems.get("unlock");
        boolean existClothing = magic_service.existClothing(name,singer);
        if (!existClothing){
            clothing clothing = new clothing();
            clothing.setClothing_IMG(img);
            clothing.setClothing_Features(features);
            clothing.setClothing_Name(name);
            clothingService.addClothing(clothing);
            singer_clothing  singer_clothing = new singer_clothing();
            singer_clothing.setSinger_Clothing_SID(magic_service.getSingerIdByName(singer));
            singer_clothing.setSinger_Clothing_CID(clothing.getClothing_ID());
            clothingService.addClothingSinger(singer_clothing);
            if (unlock!=null&&!unlock.equals("")){
                unlock = unlock.substring(1, unlock.length() - 12);
                unlock = unlock.replace('?', '？');
                unlock = unlock.replace('!','！');
                int unlockId = magic_service.existUnlockByName(unlock);
                un_lock un_lock = new un_lock();
                un_lock.setU_Name(unlock);
                un_lock.setU_ID(unlockId);
                un_lock.setU_Clothing(clothing.getClothing_ID());
                magic_service.updateUnlock(un_lock);
            }
        }


    }
}
