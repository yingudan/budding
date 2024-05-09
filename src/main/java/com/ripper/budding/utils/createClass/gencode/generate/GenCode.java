/**
 * 
 */
package util.createClass.gencode.generate;

import java.io.File;
import java.io.IOException;
import java.util.List;

import util.createClass.gencode.modelcontent.ModelEntityUtils;
import util.createClass.gencode.modelcontent.ModelMapperXMLUtils;
import util.createClass.gencode.modelcontent.ModelPageUtils;
import util.createClass.gencode.modelcontent.ModelServiceUtils;
import util.createClass.gencode.reflect.FieldColumnPojo;
import util.createClass.gencode.reflect.ReflectMain;
import util.createClass.gencode.reflect.ReflectVo;
import util.createClass.gencode.utils.GenFileUtil;

/**
 * 生成代码工具
 * 
 * @author desert
 * @version 1.0
 */
public class GenCode {
	/**
	 * 根据模块中的所有类及所有页面
	 * 
	 * @param pojoclass
	 *            生成对象的类
	 */
	public void genFile(Class<?> pojoclass) {
		ReflectMain rm = new ReflectMain();
		ReflectVo vo = rm.getReflectFieldAnnotation(pojoclass);
		if (vo != null) {
			FieldColumnPojo keyValue = vo.getKeyvalue_obj();
			List<FieldColumnPojo> list = vo.getFcp_list();
			String modelName = vo.getModelName(); // equinfo
			String tableName = vo.getTableName(); // T_EQUINFO
			String modelPackage = vo.getPackageName(); // org.qisys.db.sec.equinfo
			// String pojoClassName = vo.getPojoClassName(); //
			if (keyValue != null) {
				String keyColumn = keyValue.getColumn();
				String idValues = keyValue.getFieldName();

				// 这里最开始应该是创建对象
				ModelEntityUtils modelEntity = new ModelEntityUtils();
				// 生成文件(entityName=org.qisys.db.sec.equinfo.model.RtnTongLianEquinfo)
				String entityName = modelEntity.createModel(modelPackage, modelName, vo.getTableDesc(),
						vo.getFcp_list());

				// 生成maper xml文件
				ModelMapperXMLUtils mmu_obj = new ModelMapperXMLUtils();
				String mapperXmlContent = mmu_obj.construtMapperContent(modelPackage, entityName, modelName, tableName,
						list, keyColumn, idValues);
				genModelFolder(GenFileUtil.getProjectRootMaven(), modelPackage, modelName, "mapperxml",
						mapperXmlContent);

				// //生成maper java文件
				// ModelMapperJava mmj = new ModelMapperJava();
				// String mapperJavaContent =
				// mmj.getModelJavaInterface(modelPackage, pojoClassName,
				// modelName, idValues);
				// System.out.println(mapperJavaContent);
				// this.genModelFolder(filePath, modelPackage, modelName,
				// "mapperjava", mapperJavaContent);
				// 生成service java文件
				ModelServiceUtils msu = new ModelServiceUtils();
				String intefaceJavaContent = msu.getModelServiceInterface(modelPackage, entityName, modelName,
						idValues);
				genModelFolder(GenFileUtil.getProjectRootMaven(), modelPackage, modelName, "serviceInterface",
						intefaceJavaContent);

				// service 实现类中的内容
				String implJavaContent = msu.getModelServiceImpl(modelPackage, entityName, modelName, idValues);
				genModelFolder(GenFileUtil.getProjectRootMaven(), modelPackage, modelName, "serviceImpl",
						implJavaContent);
				// //action中的内容
				// ModelActionUtils mau = new ModelActionUtils();
				// String actionJavaContent =
				// mau.modelActionContent(modelPackage, pojoClassName,
				// modelName, idValues);
				// System.out.println(actionJavaContent);
				// this.genModelFolder(filePath, modelPackage, modelName,
				// "action", actionJavaContent);
				// 生成页面
				// ModelPageUtils mpu = new ModelPageUtils();
				// String indexJspContent = mpu.getIndexJsp(list, modelName);
				// System.out.println(indexJspContent);
				// this.genModelFolder(filePath, modelPackage, modelName,
				// "indexjsp", indexJspContent);
				//
				//
				// String gridJspContent = mpu.getGridContentJsp(list,
				// modelName);
				// System.out.println(gridJspContent);
				// this.genModelFolder(filePath, modelPackage, modelName,
				// "gridjsp", gridJspContent);
				//
				// String editContent = mpu.getEditJspContent(list, modelName);
				// System.out.println(editContent);
				// this.genModelFolder(filePath, modelPackage, modelName,
				// "editjsp", editContent);
			}
		}
	}

	/**
	 * 只生成页面
	 * 
	 * @param pojoclass
	 * @param filePath
	 * @param filePrefixName
	 */
	public void genOnlyPage(Class pojoclass, String filePath, String filePrefixName) {
		ReflectMain rm = new ReflectMain();

		ReflectVo vo = rm.getReflectFieldAnnotation(pojoclass);

		if (vo != null) {
			FieldColumnPojo keyValue = vo.getKeyvalue_obj();
			List<FieldColumnPojo> list = vo.getFcp_list();
			String modelName = vo.getModelName();
			String tableName = vo.getTableName();
			String modelPackage = vo.getPackageName();
			String pojoClassName = vo.getPojoClassName();

			if (keyValue != null) {
				String keyColumn = keyValue.getColumn();
				String idValues = keyValue.getFieldName();

				// 生成页面
				ModelPageUtils mpu = new ModelPageUtils();
				String indexJspContent = mpu.getIndexJsp(list, modelName);
				// System.out.println(indexJspContent);
				this.genOnlyPage(modelName, indexJspContent, filePath, filePrefixName, "index");

				String gridJspContent = mpu.getGridContentJsp(list, modelName);
				// System.out.println(gridJspContent);
				this.genOnlyPage(modelName, gridJspContent, filePath, filePrefixName, "grid");

				String editContent = mpu.getEditJspContent(list, modelName);
				// System.out.println(editContent);
				this.genOnlyPage(modelName, editContent, filePath, filePrefixName, "edit");

			} // end if
		} // end if
	}

	/**
	 * 只生成编辑页面
	 * 
	 * @param pojoclass
	 * @param filePath
	 */
	public void genOnlyEditPageJsp(Class pojoclass, String filePath) {
		ReflectMain rm = new ReflectMain();

		ReflectVo vo = rm.getReflectFieldAnnotation(pojoclass);

		if (vo != null) {
			FieldColumnPojo keyValue = vo.getKeyvalue_obj();
			List<FieldColumnPojo> list = vo.getFcp_list();
			String modelName = vo.getModelName();
			String modelPackage = vo.getPackageName();

			if (keyValue != null) {

				// 生成页面
				ModelPageUtils mpu = new ModelPageUtils();

				String editContent = mpu.getEditJspContent(list, modelName);
				System.out.println(editContent);
				this.genModelFolder(filePath, modelPackage, modelName, "editjsp", editContent);

			} // end if
		} // end if
	}

	// 生成指定的页面
	public void genOnlyPage(String modelName, String content, String filePath, String filePrefixName, String typeName) {

		String pagePath = filePath.replace("src", "") + "WebRoot/pages/";

		try {
			File file = GenFileUtil.createFile(pagePath + modelName, filePrefixName + "_" + typeName + ".jsp");
			GenFileUtil.writeFile(file, content); // 向文件中写内容
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param projectPath
	 *            文件保存路径
	 * @param packageName
	 *            包名
	 * @param modelName
	 * @param classType
	 * @param content
	 */
	public void genModelFolder(String projectPath, String packageName, String modelName, String classType,
			String content) {
		if (packageName != null && projectPath != null) {
			String packageNamePath = projectPath + "/" + packageName.replace(".", "/");

			StringBuffer sb = new StringBuffer(modelName);
			sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
			// 创建文件
			if (classType.trim().equals("action")) {
				try {
					File file = GenFileUtil.createFile(packageNamePath + "/action", sb.toString() + "Action.java");
					GenFileUtil.writeFile(file, content); // 向文件中写内容
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (classType.trim().equals("serviceImpl")) {
				try {
					File file = GenFileUtil.createFile(packageNamePath + "/service",
							sb.toString() + "ServiceImpl.java");
					GenFileUtil.writeFile(file, content); // 向文件中写内容
					System.out.println("生成文件：" + sb.toString() + "ServiceImpl.java");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (classType.trim().equals("serviceInterface")) {
				try {
					File file = GenFileUtil.createFile(packageNamePath + "/service", sb.toString() + "Service.java");
					GenFileUtil.writeFile(file, content); // 向文件中写内容
					System.out.println("生成文件：" + sb.toString() + "Service.java");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (classType.trim().equals("mapperxml")) {
				try {
					File file = GenFileUtil.createFile(packageNamePath + "/mapper", sb.toString() + "Mapper.xml");
					GenFileUtil.writeFile(file, content); // 向文件中写内容
					System.out.println("生成文件:" + sb.toString() + "Mapper.xml");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (classType.trim().equals("mapperjava")) {
				try {
					File file = GenFileUtil.createFile(packageNamePath + "/mapper", sb.toString() + "Mapper.java");
					GenFileUtil.writeFile(file, content); // 向文件中写内容
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (classType.trim().equals("indexjsp")) {
				try {
					File file = GenFileUtil.createFile(projectPath.replace("src", "") + "WebRoot/pages/" + modelName,
							"index.jsp");
					GenFileUtil.writeFile(file, content); // 向文件中写内容
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (classType.trim().equals("gridjsp")) {

				System.out.println("=====" + projectPath.replace("src", "") + "WebRoot/pages/");

				try {
					File file = GenFileUtil.createFile(projectPath.replace("src", "") + "/WebRoot/pages/" + modelName,
							"grid.jsp");
					GenFileUtil.writeFile(file, content); // 向文件中写内容
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (classType.trim().equals("editjsp")) {

				System.out.println("=====" + projectPath.replace("src", "") + "WebRoot/pages/");

				try {
					File file = GenFileUtil.createFile(projectPath.replace("src", "") + "/WebRoot/pages/" + modelName,
							"edit.jsp");
					GenFileUtil.writeFile(file, content); // 向文件中写内容
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] arg) {

		// 1 生成mapper

		// Class pojoclass = ProductPojo.class;
		//
		// GenCodeMain gcm = new GenCodeMain();
		//
		// gcm.genFile(pojoclass,"");
	}

}
