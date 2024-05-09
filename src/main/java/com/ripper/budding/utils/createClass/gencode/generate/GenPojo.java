/**
 * 
 */
package util.createClass.gencode.generate;

import java.io.File;
import java.io.IOException;
import java.util.List;

import util.createClass.gencode.tablestructure.TableStructs;
import util.createClass.gencode.tablestructure.TableUtils;
import util.createClass.gencode.utils.GenFileUtil;

/**
 * 生成pojoMain
 * 
 * @author desert
 * @version 1.0 2014/02/17
 */
public class GenPojo {

	/**
	 * 创建数据库中的所有表
	 * 
	 * @param packageName
	 *            包名
	 * @param databaseName
	 *            数据库名
	 */
	public void createAllTable(String packageName, String databaseName) {
		List<TableStructs> listName = TableUtils.getAllTable();
		if (listName.size() > 0) {
			for (int i = 0; i < listName.size(); i++) {
				TableStructs ts = listName.get(i);
				String tableName = ts.getTableName();
				String fileName = tableName.substring(2, tableName.length());
				String modelName = fileName.toLowerCase();
				// 这里文件名首字母需要大写
				fileName = modelName.substring(0, 1).toUpperCase() + modelName.substring(1);
				genPojoMain(packageName, modelName, tableName, databaseName, fileName, ts.getTableDesc());

			}
		}
	}

	/**
	 * @param packageName
	 *            包名
	 * @param tableNamed
	 *            表名
	 * @param databaseName
	 *            数据库名
	 */
	public void createOneTable(String packageName, String tableNamed, String databaseName) {
		List<TableStructs> listName = TableUtils.getAllTable();
		if (listName.size() > 0) {
			for (int i = 0; i < listName.size(); i++) {
				TableStructs ts = listName.get(i);
				String tableName = ts.getTableName();
				if (tableNamed.equals(tableName)) {
					String fileName = tableName.substring(2, tableName.length());
					String modelName = fileName.toLowerCase();
					// 这里文件名首字母需要大写
					fileName = modelName.substring(0, 1).toUpperCase() + modelName.substring(1);
					genPojoMain(packageName, modelName, tableName, databaseName, fileName, ts.getTableDesc());
				}
			}
		}
	}

	/**
	 * 生成pojo的核心方法
	 * 
	 * @param packageName
	 *            包的名称
	 * @param ModelName
	 *            模块的名称
	 * @param tableName
	 *            表的名称
	 * @param databaseName
	 *            数据库的名称
	 * @param tableDesc
	 *            数据库的描述
	 */
	public void genPojoMain(String packageName, String modelName, String tableName, String databaseName,
			String fileName, String tableDesc) {

		packageName = packageName + "." + modelName;
		// 生成pojo类
		StringBuffer sb = new StringBuffer();
		// 包名
		sb.append("package " + packageName + ".pojo; \r\n");
		// 导入的类名
		sb.append("import java.io.Serializable; \r\n");
		sb.append("import com.ujuit.assetsmanager.utils.createClass.gencode.annotation.GenField; \r\n");
		sb.append("import com.ujuit.assetsmanager.utils.createClass.gencode.annotation.GenModel; \r\n");
		sb.append("import com.ujuit.assetsmanager.utils.createClass.gencode.annotation.GenTable; \r\n");
		sb.append("import java.math.BigDecimal; \r\n");
		sb.append("import java.util.*; \r\n");
		// 加入三个空白行
		sb.append(" \r\n ");
		sb.append(" \r\n");
		// 文件的类定义
		sb.append("@GenTable(name=\"" + tableName + "\",desc=\"" + tableDesc + "\") \r\n");
		sb.append("@GenModel(packageName=\"" + packageName + "\",modelName=\"" + modelName + "\")  \r\n");
		sb.append("public class " + fileName + "Pojo implements Serializable{  \r\n\r\n");
		sb.append("	private static final long serialVersionUID = 1L; \r\n\r\n");
		TableUtils tu = new TableUtils();
		sb.append(tu.construtsPojo(tableName, databaseName));
		sb.append("\r\n}");
		// 生成文件
		String FilePath = GenFileUtil.getProjectRootMaven();
		try {
			String savePath = FilePath + File.separator + packageName.replace(".", "/") + "/pojo";
			System.out.println("savePath=" + savePath);
			File file = GenFileUtil.createFile(savePath, fileName + "Pojo.java");
			GenFileUtil.writeFile(file, sb.toString()); // 向文件中写内容
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] arg) {
		GenPojo genPojoMain = new GenPojo();
		// @param packageName 包的名称
		// * @param ModelName 模块的名称
		// * @param tableName 表的名称
		// * @param databaseName 数据库的名称
		// H_T_FUND
		genPojoMain.genPojoMain("com.ujuit.assetsmanager", "futurescompany", "t_futures_company", "stock-order-test",
				"Futurescompany", "期货公司信息");
		// genPojoMain.genPojoMain("net.lwyj.testhuangwei", "testhuangwei",
		// "test_huangwei", "zyzl1", "TestHuangwei");
		// genPojoMain.genPojoMain("net.lwyj.safeitemsetting", "safetyrelation",
		// "t_safety_relation", "psms", "InformationiSsuance");
		// genPojoMain.genPojoMain("net.lwyj.safeitemsetting", "safetyrelation",
		// "fl_testamentmedice", "psms", "InformationiSsuance");

	}

}
