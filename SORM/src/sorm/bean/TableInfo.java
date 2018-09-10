package sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * �洢���ṹ����Ϣ	
 * @author yangqinkuan
 *
 */
public class TableInfo {
	
	/**
	 * ����
	 */
	private String tname;
	/**
	 * �����ֶε���Ϣ
	 */
	private Map<String,ColumnInfo> columns;
	/**
	 * Ψһ����(Ŀǰ����ֻ�ܴ�����������ֻ��һ�����������)
	 */
	private ColumnInfo onlyPriKey;
	/**
	 * ��������������������ﴢ��
	 */
	private	List<ColumnInfo> priKeys; 
	
	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}
	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}
	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}
	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}
	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}
	public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
	}
	
	public TableInfo(String tname, List<ColumnInfo> priKeys, Map<String, ColumnInfo> columns) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.priKeys = priKeys;
	}
	public TableInfo() {
	}
	
} 