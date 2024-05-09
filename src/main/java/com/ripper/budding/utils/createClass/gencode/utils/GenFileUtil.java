/**
 * 
 */
package util.createClass.gencode.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 生成类文件或前台网页文件
 * 
 * @author shadow
 * @version 1.0
 */
public class GenFileUtil {

	public static String getProjectRoot() {
		File f = new File("");
		return f.getAbsolutePath();
	}

	public static String getProjectRootMaven() {
		File f = new File("");
		String path = f.getAbsolutePath() + "/src\\main\\java\\";
		// System.out.println("类文件生成路径为：" + path);
		return path;
	}

	/**
	 * 生成类文件
	 * 
	 * @param fileDir
	 *            文件路径
	 * @param fileName
	 *            文件名称
	 * @throws IOException
	 */
	public static File createFile(String fileDir, String fileName) throws IOException {

		// 创建文件夹
		if (fileDir != null) {
			File dir = new File(fileDir);
			if (!dir.exists()) {
				dir.mkdirs();
			}
		} else {
			System.err.print("文件路径不存在！");
			return null;
		}

		File file = null;

		// 创建文件
		if (fileName != null) {
			file = new File(fileDir, fileName);

			if (!file.exists()) {
				file.createNewFile();
			}
		} // end if

		return file;
	}

	/**
	 * 向文件中写入内容
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 */
	public static void writeFile(File file, String content) throws FileNotFoundException {
		RandomAccessFile mm = null;
		try {
			mm = new RandomAccessFile(file, "rw");
			mm.write(content.getBytes());
		} catch (IOException e1) {
			// TODO 自动生成 catch 块
			e1.printStackTrace();
		} finally {
			if (mm != null) {
				try {
					mm.close();
				} catch (IOException e2) {
					// TODO 自动生成 catch 块
					e2.printStackTrace();
				}
			}
		}
	}

}
