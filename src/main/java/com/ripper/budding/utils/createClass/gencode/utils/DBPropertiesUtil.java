/**
 * 
 */
package util.createClass.gencode.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

/**
 * 利用spring解析Properties文件报错
 * 
 * @author desert
 * @version 1.0
 */
public class DBPropertiesUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	public static String jdbcdrive = "";
	public static String jdbcurl = "";
	public static String jdbcuser = "";
	public static String jdbcpassword = "";

	static {
		Properties p = new Properties();
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(getPropertiesPath()));
			p.load(in);
			jdbcdrive = p.get("jdbc.drive").toString();
			jdbcurl = p.get("jdbc.url").toString();
			jdbcuser = p.get("jdbc.user").toString();
			jdbcpassword = p.get("jdbc.password").toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getPropertiesPath() {
		File f = new File("");
		return f.getAbsolutePath() + "\\src\\main\\resources\\db.properties";
	}

	public static void main(String[] arg) {
		DBPropertiesUtil dbpu_obj = new DBPropertiesUtil();
		String filePath = dbpu_obj.getPropertiesPath();
		System.out.println(filePath);
	}
}
