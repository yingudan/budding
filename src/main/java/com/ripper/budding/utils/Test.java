package com.ripper.budding.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

	// E:\soft\workpace\qisys\qisys-data-tonglian\src\main\java\org\qi\data\tonglian\param\bond
	public static void producePojo(List<Magna> magnas, String ClassName) {
		String thepath = "E:\\soft\\workpace\\qisys\\qisys-data-tonglian\\src\\main\\java\\org\\qi\\data\\tonglian\\param\\bond\\"
				+ ClassName + ".java";
		File file = new File(thepath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		} else {
			file.delete();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("package util;");
			bw.write("public class " + ClassName + "{");
			for (Magna magna : magnas) {
				if (null != magna.getRemark()) {
					bw.write("/**  " + "*" + magna.getRemark() + " **/");
				}
				bw.write("private " + magna.getType() + " " + magna.getName() + ";");
				// +"//"+magna.getRemark());
			}
			for (Magna magna : magnas) {
				bw.write("public  " + magna.getType() + " " + "get" + magna.getName().substring(0, 1).toUpperCase()
						+ magna.getName().substring(1) + "(){" + "return " + magna.getName() + "; }");
				bw.write("public  " + "void" + " " + "set" + magna.getName().substring(0, 1).toUpperCase()
						+ magna.getName().substring(1) + "(" + magna.getType() + " " + magna.getName() + ")" + "{"
						+ "this." + magna.getName() + "=" + magna.getName() + ";}");
			}
			bw.write("}\n");
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileReader fr = new FileReader(file);
			BufferedReader bReader = new BufferedReader(fr);
			String string = bReader.readLine();
			System.out.println(string);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		List<Magna> list = new ArrayList<>();
//		Magna c = new Magna();
//		c.setName("name");
//		c.setType("String");
//		c.setRemark("备注");
//		list.add(c);
//		// System.out.println(c.getType().forName(className));
//		producePojo(list, "theTest");
		
	}
}

class Magna {
	private String name;
	private String type;
	private String remark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}