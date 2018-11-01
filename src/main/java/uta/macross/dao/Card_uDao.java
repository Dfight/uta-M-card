package uta.macross.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import uta.macross.entry.cardClothingFighter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface Card_uDao {
    //根据页数获取卡面数据-筛选
    public List<HashMap<String,Object>> getAllCard(@Param("attr") List<Integer> attr,
                                                    @Param("opus") List<Integer> opus,
                                                    @Param("fighter") Integer fighter,
                                                    @Param("clothing") Integer clothing,
                                                    @Param("star") Integer star,
                                                    @Param("start") Integer start,
                                                    @Param("end") Integer end,
                                                    @Param("singer") List<Integer> singer,
                                                    @Param("skillCenter") Integer skillCenter,
                                                    @Param("skillLive")  Integer skillLive,
                                                    @Param("skillAction")  Integer skillAction);
    //获取卡类型
    public cardClothingFighter getCardType(@Param("id") Integer id);
    //获取卡(飞机)
    public HashMap<String,Object> getCardF(@Param("id") Integer id);
    //获取卡(衣服)
    public HashMap<String,Object> getCardC(@Param("id") Integer id);
    //获取歌姬byCard
    public List<HashMap<String,Object>> getSingerByCard(@Param("id") Integer id);
    //获取技能详情By 类型
    public HashMap<String,Object> getSkillByType(@Param("type") String type);
}
