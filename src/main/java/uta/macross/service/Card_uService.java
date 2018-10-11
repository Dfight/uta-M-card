package uta.macross.service;

import org.apache.ibatis.annotations.Param;
import uta.macross.entry.cardClothingFighter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Card_uService {
    //根据页数获取卡面数据-筛选
    public List<HashMap<String,Object>> getAllCard( List<Integer> attr,
                                                     List<Integer> opus,
                                                     Integer fighter,
                                                     Integer clothing,
                                                     Integer star,
                                                     Integer start,
                                                     Integer end,
                                                     List<Integer> singer);
    //获取卡类型
    public cardClothingFighter getCardType(@Param("id") Integer id);
    //获取卡(飞机)
    public HashMap<String,Object> getCardF(@Param("id") Integer id);
    //获取卡(衣服)
    public HashMap<String,Object> getCardC(@Param("id") Integer id);
    //获取歌姬byCard
    public List<HashMap<String,Object>> getSingerByCard(@Param("id") Integer id);
}

