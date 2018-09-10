package sorm.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import sorm.bean.Configuration;
import sorm.pool.DBConnPool;

/**
 * ����������Ϣ��ά�����Ӷ���Ĺ���(�������ӳع���)
 * @author Administrator
 *
 */
public class DBManager {
	/**
	 * ������Ϣ
	 */
	private static Configuration conf;
	/**
	 * ���ӳض���
	 */
	private static DBConnPool pool;
	static{ //��̬�����
		Properties pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		conf = new Configuration();
		conf.setDriver(pros.getProperty("driver"));
		conf.setPoPackage(pros.getProperty("poPackage"));
		conf.setPwd(pros.getProperty("pwd"));
		conf.setSrcPath(pros.getProperty("srcPath"));
		conf.setUrl(pros.getProperty("url"));
		conf.setUser(pros.getProperty("user"));
		conf.setUsingDB(pros.getProperty("usingDB"));
		conf.setQueryClass(pros.getProperty("queryClass"));
		conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMaxSize")));
		conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));
		
		//����TableContext
		System.out.println(TableContext.class);
		
	}
	/**
	 * �����µ�Connection����
	 * @return
	 */
	public static Connection createConn(){
		try {
			//����������
			Class.forName(conf.getDriver());
			//��������
			return DriverManager.getConnection(conf.getUrl(),
					conf.getUser(),conf.getPwd());	//Ŀǰֱ�ӽ�������,�����������ӳش���,���Ч�ʣ�����
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	
	/**
	 * ���Connection����
	 * @return
	 */
	public static Connection getConn(){
		if(pool==null){
			pool = new DBConnPool();
		}
		return pool.getConnection();
	}
	
	/**
	 * �رմ����ResultSet��Statement��Connection����
	 * @param rs
	 * @param ps
	 * @param conn
	 */
	public static void close(ResultSet rs,Statement ps,Connection conn){
		
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(ps!=null){
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		try {
// 			if(conn!=null){
//				conn.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		pool.close(conn);
	}
	/**
	 * �رմ���� Statement��Connection����
	 * @param ps
	 * @param conn
	 */
public static void close(Statement ps,Connection conn){
		
		try {
			if(ps!=null){
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		try {
//			if(conn!=null){
//				conn.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		pool.close(conn);
	}
	/**
	 * ����Configuration����
	 * @return
	 */
	public static Configuration getConf(){
		return conf;
	}
	
}
