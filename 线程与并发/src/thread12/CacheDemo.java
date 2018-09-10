package thread12;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {
	
	private Map<String,Object> cache = new HashMap<String,Object>();
	public static void main(String[] args) {
		
	}
	
	//��ֹ��ͻ�����ö�д��
	
	//��д��
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	//����
	public Object getData(String key){
		//�϶������ɶ�����д
		rwl.readLock().lock();
		Object value = null;
		try{
			//�ӻ����л�ȡ
			value = cache.get(key);
			//���û����
			if(value == null){
				//�����ͷŵ�
				rwl.readLock().unlock();
				//��д����д��������д�����ɶ�
				rwl.writeLock().lock();
				try{
				value = "aa";//ʵ����ȥ���ݿ��ѯ
				}finally {
					//����finally�϶���ִ�а����ŵ�
					rwl.writeLock().unlock();
				}
				//�ϻض���
				rwl.readLock().lock();
			}
		}finally {
			rwl.readLock().unlock();
		}
		return value;
	}
}
