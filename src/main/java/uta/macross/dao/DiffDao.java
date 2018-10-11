package uta.macross.dao;

import org.springframework.stereotype.Repository;
import uta.macross.entry.difficulty;

import java.util.List;

@Repository
public interface DiffDao {
    //添加难度
    public int addDiff(difficulty diff);
    //获取所有难度信息
    public List<difficulty> queryAllDiff();
}
