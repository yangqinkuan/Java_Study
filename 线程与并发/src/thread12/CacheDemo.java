package thread12;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {
	
	private Map<String,Object> cache = new HashMap<String,Object>();
	public static void main(String[] args) {
		
	}
	
	//防止冲突，利用读写锁
	
	//读写锁
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	//方法
	public Object getData(String key){
		//上读锁：可读不可写
		rwl.readLock().lock();
		Object value = null;
		try{
			//从缓存中获取
			value = cache.get(key);
			//如果没数据
			if(value == null){
				//读锁释放掉
				rwl.readLock().unlock();
				//上写锁，写锁：不可写，不可读
				rwl.writeLock().lock();
				try{
				value = "aa";//实际是去数据库查询
				}finally {
					//利用finally肯定会执行把锁放掉
					rwl.writeLock().unlock();
				}
				//上回读锁
				rwl.readLock().lock();
			}
		}finally {
			rwl.readLock().unlock();
		}
		return value;
	}
}
