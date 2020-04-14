package com.hpe.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hpe.dao.TrainDao;
import com.hpe.po.TrainInfo;
import com.hpe.util.SqlSessionFactoryUtil;

public class TrainServiceImpl implements TrainService {

	private TrainDao trainDao = null;
	// 注入工厂类
	private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();

	@Override
	public boolean delTrainInfo(String[] train_no) throws Exception {
		SqlSession sqlsession = sqlSessionFactory.openSession();
		trainDao = sqlsession.getMapper(TrainDao.class);
		int i = 0;
		try {
			i = trainDao.delTrainInfo(train_no);
			sqlsession.commit();
		} catch (Exception e) {
			// 4、回滚
			sqlsession.rollback();
			throw e;
		} finally {
			// 5、关闭
			sqlsession.close();
		}

		if (i >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<TrainInfo> getAllTrain() {
		SqlSession session = sqlSessionFactory.openSession();
		List<TrainInfo> list = null;
		try {
			trainDao = session.getMapper(TrainDao.class);
			list = trainDao.getAllTrain();
			System.out.println("list<TrainInfo>" + list.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public TrainInfo findTrain(String train_no) {
		SqlSession session = sqlSessionFactory.openSession();
		trainDao = session.getMapper(TrainDao.class);
		TrainInfo t = trainDao.findTrain(train_no);
		session.close();
		return t;
	}

}
