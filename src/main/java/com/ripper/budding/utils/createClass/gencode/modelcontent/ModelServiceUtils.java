/**
 * 
 */
package util.createClass.gencode.modelcontent;

import util.createClass.gencode.utils.ClassUtil;

/**
 * 构建模块中的Service 接口类的代码
 * 
 * @author desert
 * @version 1.0
 */
public class ModelServiceUtils {

	/**
	 * @param packageName
	 *            包名（org.qisys.db.sec.equinfo）
	 * @param pojoClassName
	 *            对象名（org.qisys.db.sec.equinfo.model.RtnTongLianEquinfo）
	 * @param modelName
	 *            模块名 （equinfo）
	 * @param fieldName
	 *            主键名称
	 * @return
	 */
	public String getModelServiceInterface(String packageName, String pojoClassName, String modelName,
			String fieldName) {
		// 获取对象名
		// System.out.println(pojoClassName);
		String[] quoteNames = pojoClassName.split("\\.");
		String quoteName = quoteNames[quoteNames.length - 1];

		StringBuffer sb = new StringBuffer();
		// 声明package
		sb.append("package " + packageName + ".service;" + ClassUtil.NEXT_ROW);
		// 声明需要导入的包
		sb.append("import " + pojoClassName + ";" + ClassUtil.NEXT_ROW);
		sb.append("import java.util.List;" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);
		// 把类名的首字母大写
		StringBuffer classname = new StringBuffer(modelName);
		classname.setCharAt(0, Character.toUpperCase(classname.charAt(0)));
		// 声明类
		sb.append("public interface " + classname.toString() + "Service {" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);
		// 声明方法
		// 查询方法
		// sb.append("public List<"+pojoClassName+">
		// get"+modelName+"ByPage(HashMap<String, Object> params);");
		// 插入方法
		sb.append("	Integer insert(" + quoteName + " " + modelName + ");" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);
		// 更新方法
		sb.append("	void update(" + quoteName + " " + modelName + ");" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);
		// 批量插入
		sb.append("	void insertBatch(List<" + quoteName + "> list);" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);
		// 删除方法
		sb.append(" void delete (Integer " + fieldName + ");" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);
		// 根据id进行查询sql
		sb.append("	" + quoteName + " findById(Integer " + fieldName + ");" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);
		sb.append("}");
		return sb.toString();
	}

	/**
	 * @param packageName
	 *            包名（org.qisys.db.sec.equinfo）
	 * @param pojoClassName
	 *            对象名（org.qisys.db.sec.equinfo.model.RtnTongLianEquinfo）
	 * @param modelName
	 *            模块名 （equinfo）
	 * @param fieldName
	 *            主键名称
	 * @return
	 */
	public String getModelServiceImpl(String packageName, String pojoClassName, String modelName, String fieldName) {

		StringBuffer sb = new StringBuffer();
		// 获取对象名
		String[] quoteNames = pojoClassName.split("\\.");
		String quoteName = quoteNames[quoteNames.length - 1];
		// 声明package
		sb.append("package " + packageName + ".service;" + ClassUtil.NEXT_ROW);
		// 声明需要导入的包
		// sb.append("import java.util.List;");
		// sb.append("import java.util.HashMap;");
		sb.append("import javax.annotation.Resource;" + ClassUtil.NEXT_ROW);
		sb.append("import org.springframework.stereotype.Service;" + ClassUtil.NEXT_ROW);
		// sb.append("import com.ujuit.core.mybatis.Dao;" + ClassUtil.NEXT_ROW);
		// sb.append("import com.ujuit.core.mybatis.DataItem;" +
		// ClassUtil.NEXT_ROW);
		sb.append("import com.ujuit.sysmanager.core.mybatis.Dao;" + ClassUtil.NEXT_ROW);
		sb.append("import com.ujuit.sysmanager.core.mybatis.DataItem;" + ClassUtil.NEXT_ROW);
		sb.append("import java.util.List;" + ClassUtil.NEXT_ROW);
		sb.append("import " + pojoClassName + ";" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);
		// 把类名的首字母大写
		StringBuffer classname = new StringBuffer(modelName);
		classname.setCharAt(0, Character.toUpperCase(classname.charAt(0)));
		// 声明类
		sb.append("@Service" + ClassUtil.NEXT_ROW);
		sb.append("public class " + classname.toString() + "ServiceImpl implements " + classname.toString()
				+ "Service {" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);
		sb.append("	@Resource" + ClassUtil.NEXT_ROW);
		sb.append("	private Dao mapper;" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);

		// 插入方法
		sb.append("	@Override" + ClassUtil.NEXT_ROW);
		sb.append("	public Integer insert(" + quoteName + " " + modelName + ") {" + ClassUtil.NEXT_ROW);
		// \"" + pojoClassName + "\"
		sb.append("		mapper.insert(new DataItem(" + classname.toString() + ".class,\"insert\")," + modelName + ");"
				+ ClassUtil.NEXT_ROW);
		sb.append("return " + modelName + ".getId();" + ClassUtil.NEXT_ROW);
		sb.append("	}" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);

		// 更新方法
		sb.append("	@Override" + ClassUtil.NEXT_ROW);
		sb.append("	public void update(" + quoteName + " " + modelName + ") {" + ClassUtil.NEXT_ROW);
		sb.append("		mapper.update(new DataItem(" + classname.toString() + ".class,\"update\")," + modelName + ");"
				+ ClassUtil.NEXT_ROW);
		sb.append("	}" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);

		// 更新方法
		sb.append("	@Override" + ClassUtil.NEXT_ROW);
		sb.append("	public void insertBatch(List<" + quoteName + "> list) {" + ClassUtil.NEXT_ROW);
		sb.append("		mapper.find(new DataItem(" + classname.toString() + ".class,\"insertBatch\"),list);"
				+ ClassUtil.NEXT_ROW);
		sb.append("	}" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);

		// 根据id进行查询sql
		sb.append("	@Override" + ClassUtil.NEXT_ROW);
		sb.append("	public " + quoteName + " findById(Integer " + fieldName + "){" + ClassUtil.NEXT_ROW);
		sb.append("		return mapper.find(new DataItem(" + classname.toString() + ".class,\"findById\")," + fieldName
				+ ");" + ClassUtil.NEXT_ROW);
		sb.append("	}" + ClassUtil.NEXT_ROW + ClassUtil.NEXT_ROW);
		// //删除方法

		sb.append("	@Override" + ClassUtil.NEXT_ROW);
		sb.append("public void delete (Integer " + fieldName + "){" + ClassUtil.NEXT_ROW);
		sb.append(" mapper.delete (new DataItem(" + classname.toString() + ".class,\"delete\")," + fieldName + ");"
				+ ClassUtil.NEXT_ROW);
		sb.append("}");
		sb.append("}");

		return sb.toString();
	}

}
