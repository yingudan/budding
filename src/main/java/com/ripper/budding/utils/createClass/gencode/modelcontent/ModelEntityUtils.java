package util.createClass.gencode.modelcontent;

import java.io.File;
import java.io.IOException;
import java.util.List;

import util.createClass.gencode.reflect.FieldColumnPojo;
import util.createClass.gencode.utils.ClassUtil;
import util.createClass.gencode.utils.GenFileUtil;

public class ModelEntityUtils {

	/**
	 * @param packageName
	 *            包名（org.qisys.db.sec.equinfo）
	 * @param modelName
	 *            表名（equinfo）
	 * @param tableDesc
	 *            表描述（沪深股票键盘精灵）
	 * @param fieldList
	 *            表属性列表
	 * @return 文件名称（没有要后缀名）
	 */
	public String createModel(String packageName, String modelName, String tableDesc, List<FieldColumnPojo> fieldList) {

		packageName = packageName + ".model";
		// packageName = packageName+"."+modelName;
		// "RtnTongLian" +
		String className = modelName.substring(0, 1).toUpperCase() + modelName.substring(1);
		// 生成pojo类
		StringBuffer sb = new StringBuffer();
		// 包名
		sb.append("package " + packageName + ";" + ClassUtil.NEXT_ROW);
		// 导入的类名
		// sb.append("import org.qisys.db.tonglian.AStrucTonglian; \r\n");
		sb.append("import java.math.BigDecimal; \r\n");
		sb.append("import java.util.*; \r\n");
		// 加入三个空白行
		sb.append(" \r\n ");
		sb.append(" \r\n");
		// 文件的类定义
		sb.append("/**\r\n");
		sb.append(" * " + tableDesc + "\r\n");
		sb.append(" * @author shadow\r\n");
		sb.append(" */ \r\n");
		sb.append("public class " + className + "  {" + ClassUtil.NEXT_ROW);
		sb.append(createContext(fieldList));
		sb.append("}");
		// 生成文件
		String FilePath = GenFileUtil.getProjectRootMaven();
		try {
			String savePath = FilePath + packageName.replace(".", "/");
			File file = GenFileUtil.createFile(savePath, className + ".java");
			GenFileUtil.writeFile(file, sb.toString()); // 向文件中写内容
		} catch (IOException e) {
			e.printStackTrace();
		}
		return packageName + "." + className;
	}

	/**
	 * 生成主要的载体
	 */
	public String createContext(List<FieldColumnPojo> fieldList) {
		StringBuilder sb = new StringBuilder("");
		if (fieldList != null && fieldList.size() > 0) {
			for (int i = 0; i < fieldList.size(); i++) {
				FieldColumnPojo fcp = fieldList.get(i);
				sb.append("	/**" + ClassUtil.NEXT_ROW);
				sb.append("	 *" + fcp.getLabelName() + "\r\n");
				sb.append("	 */" + ClassUtil.NEXT_ROW);
				sb.append("	private " + ClassUtil.fieldType(fcp.getValidteType()) + " " + fcp.getFieldName() + ";"
						+ ClassUtil.NEXT_ROW);

			}
			// 生成方法
			for (int i = 0; i < fieldList.size(); i++) {
				FieldColumnPojo fcp = fieldList.get(i);
				String methodName = fcp.getFieldName().substring(0, 1).toUpperCase() + fcp.getFieldName().substring(1);
				sb.append("	/** \r\n");
				sb.append("	 *" + fcp.getLabelName() + "\r\n");
				sb.append("	 */" + ClassUtil.NEXT_ROW);
				sb.append("	public " + ClassUtil.fieldType(fcp.getValidteType()) + " " + ClassUtil.GET + methodName
						+ "() {" + ClassUtil.NEXT_ROW);
				sb.append("		return " + fcp.getFieldName() + ";" + ClassUtil.NEXT_ROW);
				sb.append("	}" + ClassUtil.NEXT_ROW);
				// set方法
				sb.append("	/** \r\n");
				sb.append("	 *" + fcp.getLabelName() + "\r\n");
				sb.append("	 */" + ClassUtil.NEXT_ROW);
				sb.append("	public void " + ClassUtil.SET + methodName + "(" + ClassUtil.fieldType(fcp.getValidteType())
						+ " " + fcp.getFieldName() + ") " + "{" + ClassUtil.NEXT_ROW);
				sb.append("		this." + fcp.getFieldName() + " = " + fcp.getFieldName() + ";" + ClassUtil.NEXT_ROW);
				sb.append("	}" + ClassUtil.NEXT_ROW);
			}
		}
		return sb.toString();
	}

}
