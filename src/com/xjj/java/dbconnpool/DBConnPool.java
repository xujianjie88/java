package com.xjj.java.dbconnpool;
/**
 * 连接处的类
 * @author Administrator
 *
 */

import java.sql.Connection;
import java.util.*;
import java.util.ArrayList;

public class DBConnPool {
	
	private static List<Connection> pool;//连接池的对象
	
	private static final int POOL_MAX_SIZE=100;//最大连接数
	private static final int POOL_MIN_SIZE=10;//最小连接数
	
	public void initPool() {
		if(pool==null) {
			pool = new ArrayList<Connection>();
		}
		while(pool.size()<DBConnPool.POOL_MIN_SIZE) {
			//创建连接池
//			pool.add(DBManager.getConn());
		}
	}
	
	

}
