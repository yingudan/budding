package com.ripper.budding.word;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.xeustechnologies.jtar.TarEntry;
import org.xeustechnologies.jtar.TarOutputStream;

/**
 * 压缩文件
 * 
 * @author shadow
 */
public class Compress {

	public void toCompress() {
		FileOutputStream dest;
		TarOutputStream out;
		try {
			dest = new FileOutputStream("E:/test/11.tar");
			out = new TarOutputStream(new BufferedOutputStream(dest));
			File[] filesToTar = null;
			File file = new File("E:/test/11");
			if (file.isDirectory()) {
				filesToTar = file.listFiles();
			}
			for (File f : filesToTar) {
				System.err.println(f.getName());
				out.putNextEntry(new TarEntry(f, f.getName()));
				BufferedInputStream origin = new BufferedInputStream(new FileInputStream(f));
				int count;
				byte data[] = new byte[2048];
				while ((count = origin.read(data)) != -1) {
					out.write(data, 0, count);
				}
				out.flush();
				origin.close();
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		new Compress().toCompress();
	}
}
