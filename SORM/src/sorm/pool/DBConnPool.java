package sorm.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sorm.core.DBManager;

/**
 * ���ӳص���
 * @author yangqinkuan
 *
 */
public class DBConnPool {
	/**
	 * ���ӳض���
	 */
	private  List<Connection> pool; 
	/**
	 * ���������
	 */
	private static final int POOL_MAX_SIZE = DBManager.getConf().getPoolMaxSize();
	/**
	 * ��С������
	 */
	private static final int POOL_MIN_SIZE = DBManager.getConf().getPoolMinSize();
	

	
	
	/**
	 * ��ʼ�����ӳ�,ʹ���е��������ﵽ��Сֵ
	 */
	public void initPool(){
		if(pool==null){
			pool = new ArrayList<Connection>();
		}
		while(pool.size()<DBConnPool.POOL_MIN_SIZE){
			pool.add(DBManager.createConn());
			System.out.println("��ʼ����,������������"+pool.size());
		}
		
	}
	/**
	 * �����ӳ���ȡ��һ������
	 * @return
	 */
	public synchronized Connection getConnection(){
		int last_index = pool.size()-1;
		Connection conn = pool.get(last_index);
		pool.remove(last_index);
		return conn;
	}
	/**
	 * �����ӷŻس���
	 */
	public synchronized void close(Connection conn){
		if(pool.size()>=POOL_MAX_SIZE){
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			pool.add(conn);
		}
	}
	
	
	public DBConnPool() {
		initPool();
	}
	
}
