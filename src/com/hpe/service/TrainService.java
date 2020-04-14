package com.hpe.service;

import java.util.List;

import com.hpe.po.TrainInfo;

public interface TrainService {

	/**
	 * 删除用户
	 */
	boolean delTrainInfo(String[] train_no) throws Exception;
	
	/**
	 * 查询所有用户
	 */
	List<TrainInfo> getAllTrain();
	
	/**
	 * 根据用户Id，获取用户
	 */
	TrainInfo findTrain(String train_no);

}
