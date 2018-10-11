package uta.macross.dao;

import org.springframework.stereotype.Repository;
import uta.macross.entry.*;

@Repository
public interface CardDao {
    //添加卡
    public int addCard(card card);
    //添加作品信息
    public int addCardOpus(opus_card opusCard);
    //添加属性信息
    public int addCardAttr(attrCard attrCard);
    //添加衣服信息
    public int addCardClothing(cardClothingFighter cardClothingFighter);
    //添加飞机信息
    public int addCardFighter(cardClothingFighter cardClothingFighter);
    //添加初期
    public int addCardInit(cardInit cardInit);
    //添加满级
    public int addCardMax(cardMax cardMax);
    //添加歌姬相性
    public int addCardSinger(singer_card singer_card);
}
