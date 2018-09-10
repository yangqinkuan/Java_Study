package others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import io.util.FileUtil;
public class SplitFile {
	//�ļ���·��
	private String filePath;
	//�ļ���
	private String filename;
	//�ļ���С
	private long length;
	//����
	private int size;
	//ÿ��Ĵ�С
	private long blockSize;
	//�ָ��Ĵ��Ŀ¼
	private String destBlockPath;
	//ÿ�������
	private List<String> blockPath;
	public SplitFile(){
		blockPath = new ArrayList<String>();
	}
	public SplitFile(String filePath,String destBlockPath){
		
		this(filePath,destBlockPath,1024);
	}
	public SplitFile(String filePath,String destBlockPath,long blockSize){
		this();
		this.filePath = filePath;
		this.destBlockPath = destBlockPath;
		this.blockSize = blockSize;
		init();  
	}
	
	
	
/**
 * ��ʼ��������ȷ�������Լ��ļ���
 */
	public void init(){
		File src = null;
		//��׳��
		if(null==filePath || !(((src = new File(filePath)).exists()))){
			 return;
		}
		if(src.isDirectory()){
			return;
		}
		//�ļ���
		this.filename = src.getName();
		
		
		//������� ʵ�ʴ�С ��ÿ���С
		this.length = src.length();
		if(this.blockSize>length){
			this.blockSize = length;
		}
		//ȷ������
		size = (int)(Math.ceil(length*1.0/this.blockSize));
		initPathName();
	}
	private void initPathName(){
		for(int i=0;i<size;i++){
			this.blockPath.add(destBlockPath+"/"+this.filename+".part"+i);
		}
	}
	/**
	 * �ļ��ָ�
	 * 1���ڼ���
	 * 2����ʼλ��
	 * 3��ʵ�ʴ�С
	 * destPath �ָ��ļ��Ĵ��Ŀ¼
	 * @param args
	 * @throws IOException 
	 */
	public void split() throws IOException{
		
		
		
		
		
		long beginPos = 0; //��ʼ��
		long actualBlockSize = blockSize;//ʵ�ʴ�С
		//�������п� �Ĵ�С λ��  ��������
		for(int i =0;i<size;i++){
			if(i==size-1){
				actualBlockSize = this.length-beginPos;
			}
			splitDetail(i,beginPos,actualBlockSize);
			beginPos+=actualBlockSize;
		}
	}
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	
	public void splitDetail(int idx, long beginPos, long actualBlockSize) throws IOException {
		// 1������Դ
		File src = new File(this.filePath);//Դ�ļ�
		File dest = new File(this.blockPath.get(idx)); //Ŀ���ļ�
		// 2��ѡ����
		RandomAccessFile raf = null;	//������
		BufferedOutputStream bos=null;	//�����
		try {
			 raf  = new RandomAccessFile(src, "r");
			 bos = new BufferedOutputStream(new FileOutputStream(dest));
		
			 //��ȡ�ļ�
			 raf.seek(beginPos);
			 //������
			 byte[] flush = new byte[1024];
			 //���ܳ���
			 int len =0;
			 while(-1!=(len=raf.read(flush))){
				 //д��
				 if(actualBlockSize-len>=0){
					 bos.write(flush, 0, len);
					 actualBlockSize-=len;
				 }else{
					 bos.write(flush, 0, (int)actualBlockSize);
					 break;
				 }
			 }
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			
			FileUtil.close(raf,bos);
		}
		
	}
	/**
	 * �ļ��ĺϲ�
	 * @param args
	 * @throws IOException
	 */
	public void merge(String destPath){
		//����Դ
		File dest = new File(destPath);
		//ѡ����
		BufferedOutputStream bos = null;
		SequenceInputStream sis = null;
		//����һ������
		Vector<InputStream> vi = new Vector<InputStream>();
		
		
		
		try {
			for(int i =0;i<this.blockPath.size();i++){
				vi.add(new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i)))));
			}
			
			
			
			bos = new BufferedOutputStream(new FileOutputStream(dest,true));
			sis = new SequenceInputStream(vi.elements());
			
				
				
				//������
				byte[] flush = new byte[1024];
				//���ܳ���
				int len = 0;
				while(-1!=(len=sis.read(flush))){
					bos.write(flush,0,len);
				}
				bos.flush();
				FileUtil.close(sis);
				
			
			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			FileUtil.close(bos);
		}
		
		
		
		
		
		
		
	}
	/**
	 * �ļ��ĺϲ�
	 * @param args
	 * @throws IOException
	 */
	public void merge1(String destPath){
		//����Դ
		File dest = new File(destPath);
		//ѡ����
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(dest,true));
			BufferedInputStream bis = null;
			for(int i= 0;i<this.blockPath.size();i++){
				bis = new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i))));
				
				//������
				byte[] flush = new byte[1024];
				//���ܳ���
				int len = 0;
				while(-1!=(len=bis.read(flush))){
					bos.write(flush,0,len);
				}
				bos.flush();
				FileUtil.close(bis);
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			FileUtil.close(bos);
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	public static void main(String[] args) throws IOException {
		SplitFile split = new SplitFile("F:/10/11/test/a.txt","F:/10/11/test/a01",5);
		System.out.println(split.size);
		split.split();
		split.merge("F:/10/11/test/a01.txt");
	}
}
