package com.hpe.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 获取mybatis session操作的工具类 说明：读取“mybatisConfig.xml”文件，并且产生sqlSessionFactory的工具类
 * 
 * @author Administrator
 *
 */

public class SqlSessionFactoryUtil {
	public static SqlSessionFactory sqlSessionFactory = null;
	static {
		// 读取配置文件
		try {
			InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 构造函数
	private SqlSessionFactoryUtil() {
		
	}

	// 静态的，共有的方法
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
