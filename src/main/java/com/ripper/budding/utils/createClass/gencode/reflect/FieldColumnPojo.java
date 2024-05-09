/**
 * 
 */
package util.createClass.gencode.reflect;

import java.io.Serializable;

/**
 * 对应pojo中设置的列和属性
 * 
 * @author shadow
 * @version 1.0
 */
public class FieldColumnPojo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String column; // 列
	private String labelName; // form中显示的名称
	private String fieldName; // 属性名称
	private boolean isCondition; // 是否是主页中的查询条件
	private boolean id; // 判断该属性是否是主键
	private boolean isPermitNull; // 是否允许为空
	private String validteType; // 验证用户输入的类型
	private Integer length; // 文本的长度

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public boolean getCondition() {
		return isCondition;
	}

	public void setIsCondition(boolean isCondition) {
		this.isCondition = isCondition;
	}

	public boolean getId() {
		return id;
	}

	public void setId(boolean id) {
		this.id = id;
	}

	public boolean isCondition() {
		return isCondition;
	}

	public void setCondition(boolean isCondition) {
		this.isCondition = isCondition;
	}

	public boolean isPermitNull() {
		return isPermitNull;
	}

	public void setPermitNull(boolean isPermitNull) {
		this.isPermitNull = isPermitNull;
	}

	public String getValidteType() {
		return validteType;
	}

	public void setValidteType(String validteType) {
		this.validteType = validteType;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

}
