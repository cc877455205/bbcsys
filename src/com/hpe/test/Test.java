package com.hpe.test;

import java.util.List;

import com.hpe.po.TrainInfo;
import com.hpe.service.TrainService;
import com.hpe.service.TrainServiceImpl;

import junit.framework.TestCase;

public class Test extends TestCase {

	TrainService trainService = new TrainServiceImpl();

	public void testfindAllUser() {
		List list = trainService.getAllTrain();
		System.out.println(list);
	}

	// 删除
	public void testdeleteUser() {
		String[] strings = {"11","45"};
		try {
			trainService.delTrainInfo(strings);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//根据车次查找
	
	public void testfindTrain(){
		TrainInfo i =null;
		i = trainService.findTrain("2131");
			System.out.println(i);
	}
}
