/**
 * 
 */
package util.createClass.gencode.reflect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 根据POJO反射出来的属性值
 * 
 * @author desert
 * @version 1.0 2014/2/13
 */
public class ReflectVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String packageName; // 包名
	private String modelName; // 模块名称
	private String tableName; // 表名称
	private String pojoClassName; // pojo包的完整名称
	private String tableDesc; // 表的备注
	private List<FieldColumnPojo> fcp_list = new ArrayList<FieldColumnPojo>(); // 属性跟列的对应名称
	private FieldColumnPojo keyvalue_obj = null; // pojo中对应到数据库中的关键名称

	public String getTableDesc() {
		return tableDesc;
	}

	public void setTableDesc(String tableDesc) {
		this.tableDesc = tableDesc;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPojoClassName() {
		return pojoClassName;
	}

	public void setPojoClassName(String pojoClassName) {
		this.pojoClassName = pojoClassName;
	}

	public List<FieldColumnPojo> getFcp_list() {
		return fcp_list;
	}

	public void setFcp_list(List<FieldColumnPojo> fcp_list) {
		this.fcp_list = fcp_list;
	}

	public FieldColumnPojo getKeyvalue_obj() {
		return keyvalue_obj;
	}

	public void setKeyvalue_obj(FieldColumnPojo keyvalue_obj) {
		this.keyvalue_obj = keyvalue_obj;
	}
}
