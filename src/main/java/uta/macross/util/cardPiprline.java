package uta.macross.util;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import uta.macross.entry.card;
import uta.macross.entry.cardInit;
import uta.macross.entry.skill;

import java.util.Map;

public class cardPiprline implements Pipeline {
    public void process(ResultItems resultItems, Task task) {
        card card = (card) resultItems.get("card");

        Map<String,skill> skill=(Map<String,skill>) resultItems.get("skill");

        System.out.println(card.toString());
        System.out.println(resultItems.get("init").toString());
        System.out.println(resultItems.get("max").toString());
        System.out.println(resultItems.get("attr").toString());
        System.out.println(resultItems.get("CorF").toString());
        System.out.println(skill.entrySet().toString());
        System.out.println(resultItems.get("singer"));
    }
}
