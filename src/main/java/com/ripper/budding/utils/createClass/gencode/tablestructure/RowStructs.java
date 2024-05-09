/**
 * 
 */
package util.createClass.gencode.tablestructure;

import java.io.Serializable;

/**
 * 获取表的结构
 * 
 * @author desert
 * @version 2013/9/3
 */
public class RowStructs implements Serializable {

	private static final long serialVersionUID = 1L;

	private String columnType; // 列的类型
	private String columnName; // 列的名称
	private String columnisNull; // 列是否为空
	private String columniskey; // 是否是主键
	private String columnComent; // 列的注解
	private String textlength; // 提交的文本长度
	private String columnScale; // 精度

	public String getColumnScale() {
		return columnScale;
	}

	public void setColumnScale(String columnScale) {
		this.columnScale = columnScale;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnisNull() {
		return columnisNull;
	}

	public void setColumnisNull(String columnisNull) {
		this.columnisNull = columnisNull;
	}

	public String getColumniskey() {
		return columniskey;
	}

	public void setColumniskey(String columniskey) {
		this.columniskey = columniskey;
	}

	public String getColumnComent() {
		return columnComent;
	}

	public void setColumnComent(String columnComent) {
		this.columnComent = columnComent;
	}

	public String getTextlength() {
		return textlength;
	}

	public void setTextlength(String textlength) {
		this.textlength = textlength;
	}
}
