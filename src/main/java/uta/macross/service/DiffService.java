package uta.macross.service;

import uta.macross.entry.difficulty;

import java.util.List;

public interface DiffService {
    //添加难度
    public int addDiff(difficulty diff);
    //搜索所有难度
    public List<difficulty> queryAllDiff();
}
