package uta.macross.dao;

import org.springframework.stereotype.Repository;
import uta.macross.entry.opus;

import java.util.List;

@Repository
public interface OpusDao {
    //添加作品
    public int addOpus(opus o);
    //获取所有作品信息
    public List<opus> queryAllOpus();
    //获取作品总数
    public Integer getCountOpus();
}
