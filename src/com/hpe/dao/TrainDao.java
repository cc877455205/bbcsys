package com.hpe.dao;

import java.util.List;

import com.hpe.po.TrainInfo;

public interface TrainDao {
	
	/**
	 * 查询所有，返回一个map集合
	 * @return
	 */
	List<TrainInfo> getAllTrain();
	
	/**
	 * 删除
	 */
	int delTrainInfo(String[] train_no) throws Exception;
	
	/**
	 * 查询指定车次
	 */
	TrainInfo findTrain(String train_no);
}
