package util.createClass.gencode.main;

import java.io.File;

import util.createClass.gencode.generate.GenCode;
import util.createClass.gencode.generate.GenPojo;
import util.createClass.gencode.utils.GenFileUtil;

//import com.ujuit.assetsmanager.mastertemp.pojo.MastertempPojo;

/**
 * @author UJU104 产生代码的工具
 */
public class GenFactory {

	public static void main(String[] args) {
		GenFactory factory = new GenFactory();
		factory.createOneCode();

	}

	public void genPojo(String modelPath) {
		GenPojo genPojoMain = new GenPojo();
		modelPath = modelPath.replaceAll("/", ".");
		modelPath = modelPath.substring(0, modelPath.length() - 1);
		System.out.println(modelPath);
		genPojoMain.createAllTable(modelPath, null);

		// 执行单个文件
	}

	public void genOnePojo(String modelPath) {
		GenPojo genPojoMain = new GenPojo();
		modelPath = modelPath.replaceAll("/", ".");
		modelPath = modelPath.substring(0, modelPath.length() - 1);
		genPojoMain.createOneTable(modelPath, "T_FDMTISLATELY", null);

		// 执行单个文件
	}

	public void createCode(String modelPath) {
		File f = new File(GenFileUtil.getProjectRootMaven() + modelPath);
		GenCode gcm = new GenCode();
		String[] names = f.list();
		for (int i = 0; i < names.length; i++) {
			String modelName = names[i];
			String pojoName = modelName.substring(0, 1).toUpperCase() + modelName.substring(1) + "Pojo";
			String className = modelPath.replaceAll("/", ".") + names[i] + ".pojo." + pojoName;
			try {
				Class<?> cla = Class.forName(className);
				// System.out.println(obj.getClass().getName());
				gcm.genFile(cla);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// // 根据pojo生成代码
		// // 生成文件的路径
		System.out.println("创建成功");
	}

	public void createOneCode() {
		GenCode gcm = new GenCode();
		// gcm.genFile(FuturescompanyPojo.class);
		System.out.println("创建成功");
	}
}
